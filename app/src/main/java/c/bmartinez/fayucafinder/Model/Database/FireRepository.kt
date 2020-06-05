package c.bmartinez.fayucafinder.Model.Database

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import javax.inject.Singleton

@Singleton
class FireRepository {
    private val database = FirebaseFirestore.getInstance()
    //lateinit var  storage: FirebaseStorage
    //private val storageRef: StorageReference? = storage.reference

    fun callData(): CollectionReference {
        return database.collection("truckOwners")
    }

//    fun callStorage(): StorageReference{
//        return storageRef!!.child("testImages")
//    }
}