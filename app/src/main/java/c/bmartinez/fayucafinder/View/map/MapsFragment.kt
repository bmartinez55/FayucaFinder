package c.bmartinez.fayucafinder.View.map

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentController

import androidx.lifecycle.*
import c.bmartinez.fayucafinder.DataInjection.ViewModelFactory
import c.bmartinez.fayucafinder.Model.Trucks
import c.bmartinez.fayucafinder.R
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.google.android.gms.maps.*

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import dagger.android.support.DaggerFragment
import javax.inject.Inject

@Suppress("DEPRECATION")
class MapsFragment: DaggerFragment(),  OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener{
    //Needed for user location updates and Map
    private lateinit var map: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var lastLocation: Location
    private var locationCallback: LocationCallback = LocationCallback()
    private lateinit var locationRequest: LocationRequest
    private var locationUpdateState = false

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var mapViewModel: MapViewModel

    //Holds the data
     private var truckData: ArrayList<Trucks> = arrayListOf()

    companion object{
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
        private const val REQUEST_CHECK_SETTINGS = 2
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_map,container,false)
        val mapSupport: SupportMapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapSupport.getMapAsync(this)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        locationRequest = LocationRequest()

        return view
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapViewModel = ViewModelProviders.of(this, viewModelFactory).get(MapViewModel::class.java)
        mapViewModel.getDataFromRepo().observe(this, Observer { it ->
            if(it!!.isNotEmpty()){
                for(x in it) {
                    Log.i("INFO", "Heres the truck ${x.name}")
                    placeMarkerOnMap(x)
                    truckData.add(x)
                }
            }
            else{
                Log.d("DATA CHECK", "Data is not being collected properly")
            }
        })
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        map.uiSettings.isZoomControlsEnabled = true
        map.setOnMarkerClickListener(this)

        isFusedLocationClientInitialized()

        setUpMap()
        createLocationRequest()
    }

   private fun isPermissionGranted(): Boolean{
       return context?.let { ContextCompat.checkSelfPermission(it, Manifest.permission.ACCESS_FINE_LOCATION) } ==
               PackageManager.PERMISSION_GRANTED
   }

    @SuppressLint("MissingPermission")
    private fun setUpMap(){
        if(isPermissionGranted()) {
            map.isMyLocationEnabled = true
            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                if(location != null){
                    lastLocation = location
                    val currentCoordinates = LatLng(location.latitude, location.longitude)
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentCoordinates, 12.0f))
                }else{
                    ActivityCompat.requestPermissions(context as Activity, arrayOf<String>(
                        Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE
                    )
                }
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if(requestCode == LOCATION_PERMISSION_REQUEST_CODE){
            if(grantResults.contains(PackageManager.PERMISSION_GRANTED)){
                setUpMap()
            }
        }
    }

    private fun placeMarkerOnMap(trucks: Trucks){
        val latLng = LatLng(trucks.location!!.latitude,trucks.location.longitude)

        val markerOptions = MarkerOptions().position(latLng).title(trucks.name.toString()).snippet(trucks.description.toString()).
            infoWindowAnchor(0.5f,0.5f)

        Log.d("DATA CHECK!", "${trucks.location.latitude}, ${trucks.location.longitude}")
        map.addMarker(markerOptions)
        map.setOnInfoWindowClickListener(this)
    }

    private fun startLocationUpdates(){
        if(context?.let { ActivityCompat.checkSelfPermission(it, android.Manifest.permission.ACCESS_FINE_LOCATION) }
        != PackageManager.PERMISSION_GRANTED) {
            activity?.let {
                ActivityCompat.requestPermissions(
                    it,arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                    LOCATION_PERMISSION_REQUEST_CODE)
            }
            return
        }
        //registerLocationListener()
        fusedLocationClient.requestLocationUpdates(locationRequest,locationCallback, null)
    }

    private fun createLocationRequest() {
        locationRequest.interval = 10000

        locationRequest.fastestInterval = 5000
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        val builder = LocationSettingsRequest.Builder().addLocationRequest(locationRequest)

        val client = activity?.let { LocationServices.getSettingsClient(it) }
        val task = client?.checkLocationSettings(builder.build())

        task?.addOnSuccessListener {
            locationUpdateState = true
            startLocationUpdates()
        }

        task?.addOnFailureListener { exception ->
            if(exception is ResolvableApiException){
                //Location settings are not satisfied, but this can be fixed by showing thhe user
                // a dialog
                try{
                    //Show the dialog by calling startResolutionForResults(),
                    //and check the result in onActivityResult().
                    exception.startResolutionForResult(activity, REQUEST_CHECK_SETTINGS)
                } catch(sendException: IntentSender.SendIntentException){
                    //Ignore this error
                }
            }
        }
    }

    override fun onInfoWindowClick(p0: Marker?) {
        Toast.makeText(context, "Info window clicked", Toast.LENGTH_LONG).show()
    }

    //starts the update request if it has a RESULT_OK result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CHECK_SETTINGS){
            if(resultCode == Activity.RESULT_OK){
                locationUpdateState = true
                startLocationUpdates()
            }
        }
    }

    //stop location update request
    override fun onPause() {
        super.onPause()
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }

    override fun onStart() {
        super.onStart()
        startLocationUpdates()
    }

    //restart the location update request
    override fun onResume() {
        super.onResume()
        if(!locationUpdateState){
            startLocationUpdates()
        }
    }

    override fun onMarkerClick(p0: Marker?): Boolean = false
    private fun isFusedLocationClientInitialized() = ::fusedLocationClient.isInitialized

//    private fun registerLocationListener() {
//        //Initialize location callback object
//        locationCallback = object : LocationCallback() {
//            override fun onLocationResult(p0: LocationResult?) {
//                onLocationChanged(p0!!.lastLocation)
//            }
//        }
//    }

//    private fun onLocationChanged(location: Location){
//        map.clear()
//        map.addMarker(MarkerOptions().position(LatLng(location.latitude,location.longitude)))
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(location.latitude,location.longitude), 12.0f))
//    }

}


