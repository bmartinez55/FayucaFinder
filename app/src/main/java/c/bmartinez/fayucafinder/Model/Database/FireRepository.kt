package c.bmartinez.fayucafinder.Model.Database

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Singleton

@Singleton
class FireRepository {
    private val database = FirebaseFirestore.getInstance()
    //val trucksRepoLiveData = MutableLiveData<ArrayList<Trucks>>()

    fun callData(): CollectionReference {
        return database.collection("truckOwners")
    }
}