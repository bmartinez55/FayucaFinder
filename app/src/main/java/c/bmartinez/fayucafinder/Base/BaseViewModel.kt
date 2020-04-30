package c.bmartinez.fayucafinder.Base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import c.bmartinez.fayucafinder.Model.Database.FireRepository

abstract class BaseViewModel<S: ViewState>(val fireRepository: FireRepository, val viewState: S): ViewModel(){
    private val stateLiveData = MutableLiveData<ViewState>()

    fun getState(): MutableLiveData<ViewState>{
        return this.stateLiveData
    }

    fun resetNewActivity(){
        viewState.newActivity = null
        updateUi()
    }

    fun updateUi(){
        stateLiveData.postValue(viewState)
    }
}
