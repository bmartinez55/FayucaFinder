package c.bmartinez.fayucafinder.DataInjection.Scope

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION,AnnotationTarget.CLASS,AnnotationTarget.TYPE)
annotation class FragmentScoped