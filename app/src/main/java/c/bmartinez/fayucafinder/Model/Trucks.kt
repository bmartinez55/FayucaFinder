package c.bmartinez.fayucafinder.Model

import com.google.firebase.firestore.GeoPoint
import javax.inject.Inject
import java.util.*

data class Trucks @Inject constructor(val name: String?,
                                 val description: String?,
                                 val location: GeoPoint?){
    constructor(): this("","",null)
}