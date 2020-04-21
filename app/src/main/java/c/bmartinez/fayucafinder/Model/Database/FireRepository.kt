package c.bmartinez.fayucafinder.Model.Database

import android.util.Log
import com.google.firebase.database.*
import c.bmartinez.fayucafinder.Model.TrucksDao
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FireRepository{
    private val database = FirebaseFirestore.getInstance()
//    private val myReference = database.reference
//    private val truckNode = myReference.child("truckOwners")
//    private lateinit var onTruck: ((TrucksDao?) -> Unit)
//    private lateinit var truckId: String

//    private  val valueEventListener = object : ValueEventListener{
//        override fun onDataChange(p0: DataSnapshot) {
//            val truckData = p0.child(truckId).getValue(TrucksDao::class.java)
//            onTruck(truckData)
//            closeListener()
//        }
//        override fun onCancelled(p0: DatabaseError) {
//            onTruck(null)
//            closeListener()
//        }
//
//    }

    fun getTrucks(): CollectionReference {
        return database.collection("truckOwners")
    }

//    private fun closeListener(){
//        truckNode.removeEventListener(valueEventListener)
//    }

}
