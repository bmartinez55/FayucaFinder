package c.bmartinez.fayucafinder.DataInjection.Module

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import c.bmartinez.fayucafinder.Model.Database.FireRepository
import c.bmartinez.fayucafinder.Utilities.ViewState
import c.bmartinez.fayucafinder.View.login.LoginActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

abstract class BaseViewModel<S: ViewState>(val firebaseRepository: FireRepository,
    val viewState: S): ViewModel(){

    protected val stateLiveData = MutableLiveData<ViewState>()

    private val networkJob = Job()
    protected val networkScope = CoroutineScope(Dispatchers.IO + networkJob)

    open fun checkUserLoggedIn(){
        if(firebaseRepository.user() == null){
            viewState.newActivity = LoginActivity::class
            viewState.clearActivityOnIntent = true
            updateUi()
        }
    }

    fun handleSignOut(){
        firebaseRepository.firestoreAuth.signOut()
        checkUserLoggedIn()
    }

    fun getState(): MutableLiveData<ViewState> {
        return this.stateLiveData
    }

    fun updateUi(){
        stateLiveData.postValue(viewState)
    }
}