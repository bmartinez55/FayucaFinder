package c.bmartinez.fayucafinder.ViewModel.Modules

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import c.bmartinez.fayucafinder.ViewModel.MapViewModel
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
class DaggerViewModelFactory @Inject constructor(private val viewModelsMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>):
        ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = viewModelsMap[modelClass]
        if(creator == null) {
                for((key,value) in viewModelsMap){
                    if(modelClass.isAssignableFrom(key)){
                        creator = value
                        break
                    }
                }
            }

        if(creator == null) { throw IllegalArgumentException("Unknown model class" + modelClass) }

        try{
            return creator.get() as T
        }catch (e: Exception){
            throw RuntimeException(e)
        }
//                viewModelsMap.asIterable().firstOrNull{
//                    modelClass.isAssignableFrom(it.key)
//                }?.value ?: throw IllegalArgumentException("Unknown Model class $modelClass")
//        return try{
//            creator.get() as T
//        } catch (e: Exception){
//            throw RuntimeException(e)
//        }
    }
}