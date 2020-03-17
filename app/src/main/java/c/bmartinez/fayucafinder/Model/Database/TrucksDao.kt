package c.bmartinez.fayucafinder.Model.Database

import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.GeoPoint

data class TrucksDao(
    var name: String = "",
    var description: String = "",
    var location: GeoPoint? = null
) {

   @Exclude
   fun toMap():Map<String, Any?>{
       return mapOf(
           "Name" to name,
           "description" to description,
           "location" to location
       )
   }

}