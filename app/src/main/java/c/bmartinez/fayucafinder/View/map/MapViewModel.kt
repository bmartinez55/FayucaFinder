package c.bmartinez.fayucafinder.View.map

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import c.bmartinez.fayucafinder.Model.Database.FireRepository
import c.bmartinez.fayucafinder.Model.Trucks
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import java.lang.Exception
import javax.inject.Inject

class MapViewModel @Inject constructor(val fireRepository: FireRepository): ViewModel() {
    val TAG = "MAP_VIEW_MODEL"

    private var truckLiveData: MutableLiveData<List<Trucks>> = MutableLiveData()

    suspend fun getDataFromRepo(): LiveData<List<Trucks>>{
        fireRepository.callData()?.forEach {
            if(it != null){
                Log.d("READ DATA", "Call failed to read snapshop")
                truckLiveData.value = null
                return@forEach
            }
            val savedTruckList: MutableList<Trucks> = mutableListOf()
            savedTruckList.add(it)

        }
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
        return truckLiveData
    }
}
