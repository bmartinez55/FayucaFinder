package c.bmartinez.fayucafinder.datainjection.module

import c.bmartinez.fayucafinder.view.map.MapActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [FragmentModule::class, ViewModelModule::class])
    internal abstract fun contributeMapActivity(): MapActivity
}