package c.bmartinez.fayucafinder.Model

import com.google.firebase.firestore.GeoPoint
import javax.inject.Inject
import java.util.*

data class Trucks @Inject constructor(var name: String?,
                                 var description: String?,
                                 var location: GeoPoint?)