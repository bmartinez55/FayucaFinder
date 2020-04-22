package c.bmartinez.fayucafinder.ViewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.Exception
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(private val viewModelsMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>):
    ViewModelProvider.Factory {

    //Creates a map and provides a ViewModelFactory as an argument. When create() is invoked it will
    //able to pick the right instance from the map.
    @Throws(RuntimeException::class)
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val creatorViewModelMap = viewModelsMap[modelClass]?:
            viewModelsMap.asIterable().firstOrNull{
                modelClass.isAssignableFrom(it.key)
            }?.value ?: throw IllegalArgumentException("Unknown model class $modelClass")
        return try {
            creatorViewModelMap.get() as T
        } catch (e: Exception){
            throw RuntimeException(e)
        }
    }
}