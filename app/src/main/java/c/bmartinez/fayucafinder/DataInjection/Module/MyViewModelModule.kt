package c.bmartinez.fayucafinder.DataInjection.Module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import c.bmartinez.fayucafinder.DataInjection.Factory.DaggerViewModelFactory
import c.bmartinez.fayucafinder.DataInjection.Components.ViewModelKey
import c.bmartinez.fayucafinder.ViewModel.MapViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MyViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MapViewModel::class)
    abstract fun bindMyViewModel(mapViewModel: MapViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}