package c.bmartinez.fayucafinder.Model.Database

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

class FirebaseAuth {
    private val firestoreAuth = FirebaseAuth.getInstance()

    suspend fun currentUser(): FirebaseUser? = firestoreAuth.currentUser

    suspend fun login(email: String, password: String): AuthResult {
        return firestoreAuth.signInWithEmailAndPassword(email,password).await()
    }

    suspend fun register(email: String, password: String): AuthResult {
        return firestoreAuth.createUserWithEmailAndPassword(email,password).await()
    }

    suspend fun logout() = firestoreAuth.signOut()
}