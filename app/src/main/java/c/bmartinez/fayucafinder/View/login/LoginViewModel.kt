package c.bmartinez.fayucafinder.View.login

import android.nfc.Tag
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import c.bmartinez.fayucafinder.Model.Database.FireRepository
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class LoginViewModel @Inject constructor(val fireRepository: FireRepository): ViewModel() {
    val TAG = "LOGIN_VIEW_MODEL"


}