package c.bmartinez.fayucafinder.datainjection.Module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import c.bmartinez.fayucafinder.datainjection.Components.ViewModelKey
import c.bmartinez.fayucafinder.view.map.MapViewModel
import c.bmartinez.fayucafinder.datainjection.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MapViewModel::class)
    protected abstract fun bindMapViewModel(viewModel: MapViewModel): ViewModel
}