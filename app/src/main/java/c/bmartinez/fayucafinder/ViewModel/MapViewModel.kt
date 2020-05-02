package c.bmartinez.fayucafinder.ViewModel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import c.bmartinez.fayucafinder.Base.BaseViewModel
import c.bmartinez.fayucafinder.Base.ViewState
import c.bmartinez.fayucafinder.DataInjection.Scope.AppScoped
import c.bmartinez.fayucafinder.Model.Database.FireRepository
import c.bmartinez.fayucafinder.Model.Trucks
import c.bmartinez.fayucafinder.View.map.MapViewState
import com.google.firebase.firestore.EventListener
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

@AppScoped
class MapViewModel @Inject constructor(fireRepo: @JvmSuppressWildcards(true) FireRepository,
                                       viewState: @JvmSuppressWildcards(true) MapViewState): BaseViewModel<MapViewState>(fireRepo, viewState){
    val TAG = "MAP_VIEW_MODEL"

    private fun launchMapActivity(){
        fireRepository.getTrucks()
        viewState.trucksViewModelLiveDate = fireRepository.trucksRepoLiveData
        updateUi()
    }

}