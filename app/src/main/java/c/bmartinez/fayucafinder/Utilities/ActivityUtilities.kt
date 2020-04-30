package c.bmartinez.fayucafinder.Utilities

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import dagger.internal.Preconditions

object ActivityUtilities{
    fun addFragmentToActivity(fragmentManager: FragmentManager,
    fragment: Fragment, frameId: Int){
        Preconditions.checkNotNull(fragmentManager)
        Preconditions.checkNotNull(fragment)
        val transaction = fragmentManager.beginTransaction()
        transaction.add(frameId,fragment)
        transaction.commit()
    }
}