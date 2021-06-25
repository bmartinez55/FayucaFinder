package c.bmartinez.fayucafinder.model

import com.google.firebase.firestore.GeoPoint
import javax.inject.Inject

data class Trucks @Inject constructor(val name: String?,
                                 val description: String?,
                                 val location: GeoPoint?){
    constructor(): this("","",null)
}