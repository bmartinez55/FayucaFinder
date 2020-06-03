package c.bmartinez.fayucafinder.Model.Database

import androidx.lifecycle.MutableLiveData
import c.bmartinez.fayucafinder.Model.Trucks
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.GeoPoint
import javax.inject.Singleton

@Singleton
class FireRepository {
    private val database = FirebaseFirestore.getInstance()
    val trucksRepoLiveData = MutableLiveData<ArrayList<Trucks>>()

    fun callData(): CollectionReference{
        return database.collection("truckOwners")
    }

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
            trucks?.let { trucksRepoLiveData.postValue(trucks as ArrayList<Trucks>?) }
        }
    }

}
