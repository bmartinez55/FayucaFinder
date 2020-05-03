package c.bmartinez.fayucafinder.View.map

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
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment

import androidx.lifecycle.*
import c.bmartinez.fayucafinder.Base.BaseFragment
import c.bmartinez.fayucafinder.Base.BaseViewModel
import c.bmartinez.fayucafinder.Base.ViewState
import c.bmartinez.fayucafinder.DataInjection.Components.MyComponents
import c.bmartinez.fayucafinder.DataInjection.Scope.ActivityScoped
import c.bmartinez.fayucafinder.Model.Database.FireRepository
import c.bmartinez.fayucafinder.Model.Trucks
import c.bmartinez.fayucafinder.R
import c.bmartinez.fayucafinder.ViewModel.MapViewModel
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.google.android.gms.maps.*

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import javax.inject.Inject

@Suppress("DEPRECATION")
@ActivityScoped
class MapsFragment @Inject constructor(viewModel: @JvmSuppressWildcards(true) MapViewModel): BaseFragment<MapViewModel, MapViewState>(viewModel), OnMapReadyCallback, GoogleMap.OnMarkerClickListener{
    private lateinit var map: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var lastLocation: Location

    //Needed for user location updates
    private lateinit var locationCallback: LocationCallback
    private lateinit var locationRequest: LocationRequest


    private var locationUpdateState = false
    private lateinit var truckData: ArrayList<Trucks>
    private lateinit var components: MyComponents.Builder

    companion object{
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1

        private const val REQUEST_CHECK_SETTINGS = 2
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        components.build()
        this.viewModel = ViewModelProviders.of(this, viewModelFactory).get(MapViewModel::class.java)
        viewModel.startInitialActivity()

        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_map,container,false)
        val mapSupport: SupportMapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        mapSupport.getMapAsync(this)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this.context)
        locationRequest = LocationRequest()

        return view
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

    private fun setUpMap(){
        if(context?.let { ActivityCompat.checkSelfPermission(it, android.Manifest.permission.ACCESS_FINE_LOCATION) } !=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                context as Activity, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
            LOCATION_PERMISSION_REQUEST_CODE)
            return
        }
        getCurrentLocation()
    }

    private fun getCurrentLocation(){
        map.isMyLocationEnabled = true

        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            if(location != null){
                lastLocation = location
                val currentCoordinates = LatLng(location.latitude, location.longitude)
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentCoordinates, 12.0f))
            }
        }
    }

    private fun placeMarkerOnMap(location: LatLng){
        val markerOptions = MarkerOptions().position(location)

        map.addMarker(markerOptions)
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

    private fun setUpMarkersOfTrucks(trucks: ArrayList<Trucks>) {
        for(it in trucks){
            val latLng = LatLng(it.location.latitude, it.location.longitude)
            placeMarkerOnMap(latLng)
        }
    }

    override fun updateUi(state: MapViewState) {
        state.trucksViewModelLiveDate?.observe(this, Observer {
            setUpMarkersOfTrucks(it)
        })
    }

    override fun attachClickListeners() {
        TODO("Not yet implemented")
    }

    override fun getLayoutResourceFile(): Int {
        TODO("Not yet implemented")
    }


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


