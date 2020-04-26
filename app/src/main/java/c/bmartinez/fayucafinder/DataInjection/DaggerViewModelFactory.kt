package c.bmartinez.fayucafinder.DataInjection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class DaggerViewModelFactory @Inject constructor(private val viewmodelsMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>):
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = viewmodelsMap[modelClass] ?:
            viewmodelsMap.entries.first{ modelClass.isAssignableFrom(it.key)}.value

        try{
            return creator.get() as T
        }catch (e: Exception){
            throw RuntimeException(e)
        }
    }
}