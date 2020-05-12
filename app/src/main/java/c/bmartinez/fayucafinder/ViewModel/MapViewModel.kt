package c.bmartinez.fayucafinder.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import c.bmartinez.fayucafinder.Model.Database.FireRepository
import c.bmartinez.fayucafinder.Model.Trucks
import javax.inject.Inject

class MapViewModel @Inject constructor(truckDao: Trucks): ViewModel() {
    val TAG = "MAP_VIEW_MODEL"

    private lateinit var truckRepository: FireRepository
    private val truckLiveData = MutableLiveData<ArrayList<Trucks>>()

    private fun launchMapActivity(){
        truckRepository.getTrucks()
    }

    fun getTruckData() = truckLiveData

}