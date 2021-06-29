package c.bmartinez.fayucafinder.view.map

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MapViewModel @Inject constructor(private val app: Application): ViewModel() {
    val TAG = MapViewModel::class.java.name


    //suspend fun getDataFromRepo(): LiveData<List<Trucks>>{

//            .addSnapshotListener(EventListener<QuerySnapshot> {value, exc ->
//            if(exc != null){
//                Log.d("READ DATA", "Call failed to read snapshop")
//                truckLiveData.value = null
//                return@EventListener
//            }
//            val savedTrucksList: MutableList<Trucks> = mutableListOf()
//            for(it in value!!){
//                val truckObj = it.toObject(Trucks::class.java)
//                savedTrucksList.add(truckObj)
//            }
//            truckLiveData.value = savedTrucksList
//        })
        //return truckLiveData
    //}
}
