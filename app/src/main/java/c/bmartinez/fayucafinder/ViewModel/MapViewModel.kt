package c.bmartinez.fayucafinder.ViewModel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import c.bmartinez.fayucafinder.Model.Database.TrucksDao
import c.bmartinez.fayucafinder.Model.FirebaseRepository
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue

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