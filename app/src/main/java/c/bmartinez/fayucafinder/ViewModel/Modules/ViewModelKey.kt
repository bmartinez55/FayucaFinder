package c.bmartinez.fayucafinder.ViewModel.Modules

import androidx.lifecycle.ViewModel
import c.bmartinez.fayucafinder.ViewModel.MapViewModel
import dagger.MapKey
import java.lang.annotation.RetentionPolicy
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)