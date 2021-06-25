package c.bmartinez.fayucafinder.model

import c.bmartinez.fayucafinder.model.Database.FirebaseAuth

class User constructor(private val firebaseSource: FirebaseAuth) {
    suspend fun login(email: String, password: String) = firebaseSource.login(email,password)

    suspend fun register(email: String, password: String) = firebaseSource.register(email, password)

    suspend fun currentUser() = firebaseSource.currentUser()

    suspend fun logout() = firebaseSource.logout()
}