package c.bmartinez.fayucafinder.Model.Database

import androidx.lifecycle.MutableLiveData
import c.bmartinez.fayucafinder.Model.Trucks
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.GeoPoint
import javax.inject.Inject

class FireRepository {
    private val database = FirebaseFirestore.getInstance()
    private val trucksLiveData = MutableLiveData<ArrayList<Trucks>>()

    fun getTrucks() {
        database.collection("truckOwners").addSnapshotListener{ snapShot, exception ->
            if(exception != null){
                exception.printStackTrace()
                return@addSnapshotListener
            }

            val trucks = snapShot?.documents?.map{
                Trucks(
                    it["Name"] as String,
                    it["description"] as String,
                    (it["location"]) as GeoPoint
                )
            }
            trucks?.let { trucksLiveData.postValue(trucks as ArrayList<Trucks>?) }
        }
    }

}
