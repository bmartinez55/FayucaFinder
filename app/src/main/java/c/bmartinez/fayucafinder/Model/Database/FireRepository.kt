package c.bmartinez.fayucafinder.Model.Database

import com.google.firebase.database.*
import androidx.lifecycle.LiveData
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
//: LiveData<DataSnapshot>()
class FireRepository{
    private val fireDB = FirebaseFirestore.getInstance()

    fun getTrucks(): CollectionReference{
        return fireDB.collection("truckOwners")
    }






//    private val database = FirebaseDatabase.getInstance()
//    private val myReference = database.reference
//    private val truckNode = myReference.child("truckOwners")
//    private lateinit var onTruck:((TrucksDao?) -> Unit)
//    private lateinit var truckIDName: String

//    private val valueEventListener = object : ValueEventListener{
//        override fun onCancelled(error: DatabaseError) {
//            TrucksDao(null)
//            onInactive()
//        }
//
//        override fun onDataChange(truckData: DataSnapshot) {
//            val truck = truckData.child(truckIDName).getValue(TrucksDao::class.java)
//            TrucksDao(truck as String)
//            onInactive()
//        }
//
//    }

//    fun getTrucks(id: String, onTruck: ((TrucksDao?) -> Unit)){
//        this.onTruck = onTruck
//        this.truckIDName = id
//        truckNode.addListenerForSingleValueEvent(valueEventListener)
//    }

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
