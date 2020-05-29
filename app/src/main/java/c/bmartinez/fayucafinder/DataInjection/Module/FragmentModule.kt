package c.bmartinez.fayucafinder.DataInjection.Module

import c.bmartinez.fayucafinder.View.map.MapsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun bindMapFragmentInjectorFactory(): MapsFragment
}