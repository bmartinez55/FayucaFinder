package c.bmartinez.fayucafinder.Base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import c.bmartinez.fayucafinder.Model.Database.FireRepository
import c.bmartinez.fayucafinder.View.map.MapActivity

abstract class BaseViewModel<S: ViewState>(val fireRepository: FireRepository, var viewState: S): ViewModel(){
    private val stateLiveData = MutableLiveData<ViewState>()

    open fun startInitialActivity(){
        viewState.newActivity = MapActivity::class
        viewState.clearActivityIntent = true
        updateUi()
    }

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
