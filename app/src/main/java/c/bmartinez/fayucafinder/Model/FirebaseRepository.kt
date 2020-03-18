package c.bmartinez.fayucafinder.Model

import android.renderscript.Sampler
import android.util.Log
import com.google.firebase.database.*
import androidx.lifecycle.LiveData

class FirebaseRepository: LiveData<DataSnapshot>(){
    private val LOG_TAG: String = "FirebaseRepository"
    private lateinit var query: Query
    private lateinit var listener: MyValueEventListener
    private lateinit var myReference: DatabaseReference

    init {
        query = query
        query = myReference
    }

    override fun onActive() {
        Log.d(LOG_TAG, "Location: onActive")
        query.addValueEventListener(listener)
    }

    override fun onInactive() {
        Log.d(LOG_TAG, "Location: onInactive")
        query.removeEventListener(listener)
    }

    inner class MyValueEventListener: ValueEventListener{
        override fun onCancelled(dataError: DatabaseError) {
            Log.e(LOG_TAG, "Can't listen to query $query", dataError.toException())
        }

        override fun onDataChange(data: DataSnapshot) {
            value = data
        }

    }
}
