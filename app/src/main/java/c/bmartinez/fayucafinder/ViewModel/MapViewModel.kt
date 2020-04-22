package c.bmartinez.fayucafinder.ViewModel

import android.app.Application
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

    //constructor(application: Application) : this() { super(application)}

    fun getTrucks(): LiveData<List<TrucksDao>>{
        fireRepo.getTrucks().addSnapshotListener(EventListener{value, e ->
            if(e != null) {
                Log.w(TAG, "Listen Failed", e)
                return@EventListener
            }

            val truckList: MutableList<TrucksDao> = mutableListOf()
            for(trucksObject in value!!){
                val truck = trucksObject.toObject(TrucksDao::class.java)
                truckList.add(truck)
            }
            trucks.value = truckList
        })

        return trucks
    }
}