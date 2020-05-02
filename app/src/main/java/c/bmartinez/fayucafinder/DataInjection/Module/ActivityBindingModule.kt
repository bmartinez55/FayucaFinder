package c.bmartinez.fayucafinder.DataInjection.Module

import c.bmartinez.fayucafinder.DataInjection.Scope.ActivityScoped
import c.bmartinez.fayucafinder.View.map.MapActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @Provides
    //@ContributesAndroidInjector(modules = [MapActivity::class])
    fun mapActivity(): MapActivity = MapActivity()
}