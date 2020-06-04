package c.bmartinez.fayucafinder.View.map

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import c.bmartinez.fayucafinder.Model.Database.FireRepository
import c.bmartinez.fayucafinder.Model.Trucks
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import java.lang.Exception
import javax.inject.Inject

class MapViewModel @Inject constructor(val fireRepository: FireRepository): ViewModel() {
    val TAG = "MAP_VIEW_MODEL"

    private var truckLiveData: MutableLiveData<List<Trucks>> = MutableLiveData()

    fun getDataFromRepo(): LiveData<List<Trucks>>{
        fireRepository.callData().get().addOnSuccessListener { it ->
            if(it != null){
                val holderDataList: MutableList<Trucks> = mutableListOf()
                for(i in it) {
                    val truck = i.toObject<Trucks>()
                    holderDataList.add(truck)
                }
                truckLiveData.value = holderDataList
                Log.d("READ DATA", "Data was read successfully")
            }else {
                Log.d("READ DATA", "Data was not read successfully")
            }
        }
            .addOnFailureListener { exception ->
                Log.d("READ DATA", "Getting data failed with ", exception)
            }
        return truckLiveData
    }
//    .addSnapshotListener(EventListener<QuerySnapshot> { snapShot, exception ->
//        if(exception != null){
//            exception.printStackTrace()
//            return@EventListener
//        }
//
//        var holderDataList: MutableList<Trucks> = mutableListOf()
//        for(truck in snapShot!!){
//            var holdingVar = truck.toObject(Trucks::class.java)
//            holderDataList.add(holdingVar)
//        }
}
