package c.bmartinez.fayucafinder.DataInjection.Module

import c.bmartinez.fayucafinder.DataInjection.Components.MyComponents
import c.bmartinez.fayucafinder.View.map.MapsFragment
import c.bmartinez.fayucafinder.ViewModel.DaggerViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun bindMapFragmentInjectorFactory(): MapsFragment
}