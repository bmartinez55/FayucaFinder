package c.bmartinez.fayucafinder.DataInjection.Module

import c.bmartinez.fayucafinder.View.map.MapActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    abstract fun mapActivity(): MapActivity
}