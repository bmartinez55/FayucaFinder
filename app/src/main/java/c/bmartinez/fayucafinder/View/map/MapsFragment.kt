package c.bmartinez.fayucafinder.View.map

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import c.bmartinez.fayucafinder.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.*

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
//Fragment()
class MapsFragment() :Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private lateinit var map: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var lastLocation: Location

    companion object{
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater.inflate(R.layout.fragment_map,container,false)
        var mapSupport: SupportMapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        mapSupport.getMapAsync(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this.context!!)
        return view
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_map)
//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
//        mapFragment.getMapAsync(this)
//
//        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

    //}

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

        setUpMap()
        isFusedLocationClientInitialized()
        getCurrentLocation()

    }

    private fun setUpMap(){
        if(context?.let { ActivityCompat.checkSelfPermission(it, android.Manifest.permission.ACCESS_FINE_LOCATION) } !=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                context as Activity, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
            LOCATION_PERMISSION_REQUEST_CODE)
            return
        }
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

    override fun onMarkerClick(p0: Marker?): Boolean = false

    private fun isFusedLocationClientInitialized() = ::fusedLocationClient.isInitialized
}
