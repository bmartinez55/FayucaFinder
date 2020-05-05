package c.bmartinez.fayucafinder.DataInjection.Module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import c.bmartinez.fayucafinder.DataInjection.Components.ViewModelKey
import c.bmartinez.fayucafinder.ViewModel.DaggerViewModelFactory
import c.bmartinez.fayucafinder.ViewModel.MapViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MapViewModel::class)
    protected abstract fun bindMapViewModel(viewModel: MapViewModel): ViewModel
}