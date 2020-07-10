package c.bmartinez.fayucafinder.Model.Database

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.tasks.await
import javax.inject.Singleton

@Singleton
class FireRepository {
    private val database = FirebaseFirestore.getInstance()

    //lateinit var  storage: FirebaseStorage
    //private val storageRef: StorageReference? = storage.reference

    //Switched from CollectionReference
    suspend fun callData(): QuerySnapshot? {
        return database.collection("truckOwners").get().await()
    }

//    fun callStorage(): StorageReference{
//        return storageRef!!.child("testImages")
//    }
}