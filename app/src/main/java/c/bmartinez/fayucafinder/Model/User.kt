package c.bmartinez.fayucafinder.Model

import c.bmartinez.fayucafinder.Model.Database.FirebaseAuth

class User constructor(private val firebaseSource: FirebaseAuth) {
    suspend fun login(email: String, password: String) = firebaseSource.login(email,password)

    suspend fun register(email: String, password: String) = firebaseSource.register(email, password)

    suspend fun currentUser() = firebaseSource.currentUser()

    suspend fun logout() = firebaseSource.logout()
}