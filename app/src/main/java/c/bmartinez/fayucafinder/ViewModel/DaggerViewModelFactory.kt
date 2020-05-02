package c.bmartinez.fayucafinder.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import c.bmartinez.fayucafinder.DataInjection.Scope.AppScoped
import java.lang.Exception
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@AppScoped
class DaggerViewModelFactory @Inject constructor(private val viewModels: @JvmSuppressWildcards(true) Map<Class<out ViewModel>, @JvmSuppressWildcards(true) Provider<ViewModel>>):
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        try{
            val provider = viewModels[modelClass]?: viewModels.entries.first{
                modelClass.isAssignableFrom(it.key)
            }.value
            return provider.get() as T
        }catch (e: Exception){
            throw RuntimeException(e)
        }
    }
}