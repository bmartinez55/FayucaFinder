package c.bmartinez.fayucafinder.Model

import com.google.firebase.firestore.GeoPoint
import java.io.Serializable

data class TrucksDao(var idName: String? = "",
    var name: String? = null,
    var description: String? = null,
    var location: GeoPoint? = null) : Serializable{

    constructor(): this("","","",null)

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