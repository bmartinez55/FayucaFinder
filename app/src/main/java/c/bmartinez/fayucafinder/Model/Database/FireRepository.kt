package c.bmartinez.fayucafinder.Model.Database

import android.util.Log
import com.google.firebase.database.*
import androidx.lifecycle.LiveData
import c.bmartinez.fayucafinder.Model.TrucksDao
import com.google.firebase.database.ktx.getValue
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
//: LiveData<DataSnapshot>()
class FireRepository{

    private val database = FirebaseDatabase.getInstance()
    private val myReference = database.reference
    private val truckNode = myReference.child("truckOwners")
    private lateinit var onTruck: ((TrucksDao?) -> Unit)
    private lateinit var truckId: String

    private  val valueEventListener = object : ValueEventListener{
        override fun onDataChange(p0: DataSnapshot) {
            val truckData = p0.child(truckId).getValue(TrucksDao::class.java)
            onTruck(truckData)
            closeListener()
        }
        override fun onCancelled(p0: DatabaseError) {
            onTruck(null)
            closeListener()
        }

    }

    fun getTruck(id: String, onTruck: ((TrucksDao?) -> Unit)){
        
    }

    private fun closeListener(){
        truckNode.removeEventListener(valueEventListener)
    }

//    override fun onActive() {
//        Log.d("FirebaseRepository ", "Location: onActive")
//        truckNode.addValueEventListener(valueEventListener)
//    }
//
//    override fun onInactive() {
//        Log.d("FirebaseRepository ", "Location: onInactive")
//        truckNode.removeEventListener(valueEventListener)
//    }

}
