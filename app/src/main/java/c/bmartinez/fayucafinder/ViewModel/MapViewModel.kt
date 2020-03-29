package c.bmartinez.fayucafinder.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import c.bmartinez.fayucafinder.Model.TrucksDao
import com.google.firebase.database.*

class MapViewModel : ViewModel() {
//    private val repository: FirebaseDatabase = FirebaseDatabase.getInstance()
//    private val myRef: DatabaseReference = repository.getReference("truckOwners")
    private val trucks: MutableLiveData<ArrayList<TrucksDao>> = MutableLiveData()

    fun getTrucks(): LiveData<ArrayList<TrucksDao>>{
        if(trucks.value == null){
            FirebaseDatabase.getInstance().getReference("truckOwners")
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onCancelled(dataError: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                    override fun onDataChange(data: DataSnapshot) {
                        if(data.exists()){
                            trucks.postValue()
                        }
                    }

                })
        }
        return trucks
    }

    private fun loadTrucks(){

    }
}