@file:Suppress("UNCHECKED_CAST")

package c.bmartinez.fayucafinder.datainjection
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider


class ViewModelFactory @Inject
constructor(private val viewModels: MutableMap<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //Loops through the allowable keys (allowed classes with the @ViewModelKey)
        //If succeeded, set the Provider<ViewModel>
        val creator = viewModels[modelClass]
            ?: viewModels.asIterable().firstOrNull { modelClass.isAssignableFrom(it.key) }?.value
            ?: throw IllegalArgumentException("unknown model class $modelClass")
        return try {
            creator.get() as T //Return the Provider
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}