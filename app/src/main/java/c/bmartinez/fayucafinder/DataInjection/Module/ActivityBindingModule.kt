package c.bmartinez.fayucafinder.DataInjection.Module

import c.bmartinez.fayucafinder.DataInjection.Scope.ActivityScoped
import c.bmartinez.fayucafinder.View.map.MapActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [MapActivity::class])
    internal abstract fun mapActivity(): MapActivity
}