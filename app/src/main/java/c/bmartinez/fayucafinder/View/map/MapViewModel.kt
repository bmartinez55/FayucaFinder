package c.bmartinez.fayucafinder.View.map

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import c.bmartinez.fayucafinder.Model.Database.FireRepository
import c.bmartinez.fayucafinder.Model.Trucks
import javax.inject.Inject

class MapViewModel @Inject constructor(val fireRepository: FireRepository): ViewModel() {
    val TAG = "MAP_VIEW_MODEL"

    private var truckLiveData = MutableLiveData<ArrayList<Trucks>>()

    private fun loadData(){
        fireRepository.getTrucks()
    }

    fun getTruckData() = truckLiveData

}