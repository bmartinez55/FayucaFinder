package c.bmartinez.fayucafinder.datainjection.Module

import c.bmartinez.fayucafinder.view.map.MapsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun bindMapFragmentInjectorFactory(): MapsFragment
}