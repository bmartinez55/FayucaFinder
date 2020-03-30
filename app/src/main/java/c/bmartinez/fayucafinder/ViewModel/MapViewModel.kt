package c.bmartinez.fayucafinder.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import c.bmartinez.fayucafinder.Model.Database.FireRepository
import c.bmartinez.fayucafinder.Model.TrucksDao
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.toObject

class MapViewModel(private val fireRepo: FireRepository) : ViewModel() {
    val TAG = "MAP_VIEW_MODEL"
    private var trucks: MutableLiveData<List<TrucksDao>> = MutableLiveData()

    fun getTrucks(): LiveData<List<TrucksDao>>{
        fireRepo.getTrucks().addSnapshotListener(EventListener<QuerySnapshot>{value, e ->
            if(e != null) {
                Log.w(TAG, "Listen Failed", e)
                return@EventListener
            }

            var truckList: MutableList<TrucksDao> = mutableListOf()
            for(trucksObject in value!!){
                var truck = trucksObject.toObject(TrucksDao::class.java)
                truckList.add(truck)
            }
            trucks.value = truckList
        })

        return trucks
//        if(trucks.value == null){
//            FirebaseDatabase.getInstance().getReference("truckOwners")
//                .addListenerForSingleValueEvent(object : ValueEventListener {
//                    override fun onCancelled(dataError: DatabaseError) {
//                        TODO("Not yet implemented")
//                    }
//
//                    override fun onDataChange(data: DataSnapshot) {
//                        if(data.exists()){
//                            trucks.postValue()
//                        }
//                    }
//
//                })
//        }
//        return trucks
    }

    private fun loadTrucks(){

    }
}