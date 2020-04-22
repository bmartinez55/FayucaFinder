package c.bmartinez.fayucafinder.ViewModel.Modules

import androidx.lifecycle.ViewModel
import c.bmartinez.fayucafinder.ViewModel.MapViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MapKey
annotation class ViewModelKey(val value: KClass<MapViewModel>)