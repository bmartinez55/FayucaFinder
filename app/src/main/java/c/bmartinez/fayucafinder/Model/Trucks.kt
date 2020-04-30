package c.bmartinez.fayucafinder.Model

import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.firestore.GeoPoint

@IgnoreExtraProperties
data class Trucks(val name: String,
                  val description: String,
                  val location: GeoPoint){

    fun getTruckName(): String {
        return name
    }

    fun getTruckDescription(): String {
        return description
    }

    fun getTruckLocation(): GeoPoint {
        return location
    }
}