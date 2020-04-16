package c.bmartinez.fayucafinder.Model

import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.firestore.GeoPoint

@IgnoreExtraProperties
data class TrucksDao(var idName: String? = "",
    var name: String? = null,
    var description: String? = null,
    var location: GeoPoint? = null){

    fun getTruckName(): String? {
        return name
    }

    fun getTruckDescription(): String? {
        return description
    }

    fun getTruckLocation(): GeoPoint? {
        return location
    }
}