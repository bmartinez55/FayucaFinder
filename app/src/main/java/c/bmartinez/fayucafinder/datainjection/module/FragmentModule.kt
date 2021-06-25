package c.bmartinez.fayucafinder.datainjection.module

import c.bmartinez.fayucafinder.view.map.MapsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Injects fragments and creates sub-components for them
 */

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun bindMapFragmentInjectorFactory(): MapsFragment
}