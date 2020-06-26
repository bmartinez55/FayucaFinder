package c.bmartinez.fayucafinder.Model.Database

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.tasks.await
import javax.inject.Singleton

@Singleton
class FireRepository {
    private val database = FirebaseFirestore.getInstance()
    private val firestoreAuth = FirebaseAuth.getInstance()
    //lateinit var  storage: FirebaseStorage
    //private val storageRef: StorageReference? = storage.reference

    fun user(): FirebaseUser? = firestoreAuth.currentUser

    suspend fun login(email: String, password: String): AuthResult {
        return firestoreAuth.signInWithEmailAndPassword(email,password).await()
    }

    suspend fun register(email: String, password: String): AuthResult {
        return firestoreAuth.createUserWithEmailAndPassword(email,password).await()
    }

    fun callData(): CollectionReference {
        return database.collection("truckOwners")
    }

//    fun callStorage(): StorageReference{
//        return storageRef!!.child("testImages")
//    }
}