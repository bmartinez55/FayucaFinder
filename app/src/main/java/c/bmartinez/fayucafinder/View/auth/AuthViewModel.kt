package c.bmartinez.fayucafinder.View.auth

import androidx.lifecycle.ViewModel
import c.bmartinez.fayucafinder.Model.Database.FirebaseAuth
import javax.inject.Inject

class AuthViewModel @Inject constructor(val firebaseSource: FirebaseAuth): ViewModel() {
    private val TAG = "AuthViewModel"

    
}