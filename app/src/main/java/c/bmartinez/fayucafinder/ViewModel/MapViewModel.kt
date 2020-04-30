package c.bmartinez.fayucafinder.ViewModel

import android.util.Log
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
import javax.inject.Inject

@AppScoped
class MapViewModel @Inject constructor(fireRepo: FireRepository,
    viewState: MapViewState): BaseViewModel<MapViewState>(fireRepo, viewState){
    val TAG = "MAP_VIEW_MODEL"
    private var trucks: MutableLiveData<List<Trucks>> = MutableLiveData()

    fun getTrucks(): LiveData<List<Trucks>>{
        fireRepo.getTrucks().addSnapshotListener(EventListener{value, e ->
            if(e != null) {
                Log.w(TAG, "Listen Failed", e)
                return@EventListener
            }

            val truckList: MutableList<Trucks> = mutableListOf()
            for(trucksObject in value!!){
                val truck = trucksObject.toObject(Trucks::class.java)
                truckList.add(truck)
            }
            trucks.value = truckList
        })

        return trucks
    }
}