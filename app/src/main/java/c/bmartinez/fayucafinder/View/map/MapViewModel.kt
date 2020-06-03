package c.bmartinez.fayucafinder.View.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import c.bmartinez.fayucafinder.Model.Database.FireRepository
import c.bmartinez.fayucafinder.Model.Trucks
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.GeoPoint
import com.google.firebase.firestore.QuerySnapshot
import javax.inject.Inject

class MapViewModel @Inject constructor(val fireRepository: FireRepository): ViewModel() {
    val TAG = "MAP_VIEW_MODEL"

    private var truckLiveData: MutableLiveData<List<Trucks>> = MutableLiveData()

    fun getDataFromRepo(): LiveData<List<Trucks>>{
        fireRepository.callData().addSnapshotListener(EventListener<QuerySnapshot> { snapShot, exception ->
            if(exception != null){
                exception.printStackTrace()
                return@EventListener
            }

            var holderDataList: MutableList<Trucks> = mutableListOf()
            for(truck in snapShot!!){
                var holdingVar = truck.toObject(Trucks::class.java)
                holderDataList.add(holdingVar)
            }
//            val trucks = snapShot?.documents?.map{
//                Trucks(
//                    it["Name"] as String,
//                    it["description"] as String,
//                    (it["location"]) as GeoPoint
//                )
//            }
            //trucks?.let { trucksRepoLiveData.postValue(trucks as ArrayList<Trucks>?) }
            truckLiveData.value = holderDataList
        })
        return truckLiveData
    }

    //fun getTruckData() = truckLiveData

}