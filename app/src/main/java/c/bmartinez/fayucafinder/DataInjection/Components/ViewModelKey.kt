package c.bmartinez.fayucafinder.DataInjection.Components

import androidx.lifecycle.ViewModel
import c.bmartinez.fayucafinder.ViewModel.MapViewModel
import dagger.MapKey
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier
import kotlin.reflect.KClass

@Qualifier
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)