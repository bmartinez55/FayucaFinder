package c.bmartinez.fayucafinder.Model

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import c.bmartinez.fayucafinder.BuildConfig
import c.bmartinez.fayucafinder.Model.Database.TrucksDao
import c.bmartinez.fayucafinder.R
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue

abstract class FirebaseRepository {
    private val repository: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val myRef: DatabaseReference = repository.getReference("truckOwners")

    fun readData(){
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read data", error.toException())
            }

            override fun onDataChange(data: DataSnapshot) {
                //This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = data.getValue<TrucksDao>()
                Log.d(TAG, "Value is: $value")
            }

        })
    }
}
