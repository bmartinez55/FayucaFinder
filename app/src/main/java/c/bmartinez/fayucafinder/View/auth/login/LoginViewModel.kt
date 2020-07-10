package c.bmartinez.fayucafinder.View.auth.login

import androidx.lifecycle.ViewModel
import c.bmartinez.fayucafinder.Model.Database.FireRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor(val fireRepository: FireRepository): ViewModel() {
    val TAG = "LOGIN_VIEW_MODEL"

    val user = fireRepository.user()

    suspend fun signInWithEmailPassword(email: String, password: String){
        fireRepository.login(email,password)
    }
}