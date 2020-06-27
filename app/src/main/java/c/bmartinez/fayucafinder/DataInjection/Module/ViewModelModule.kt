package c.bmartinez.fayucafinder.DataInjection.Module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import c.bmartinez.fayucafinder.DataInjection.Components.ViewModelKey
import c.bmartinez.fayucafinder.View.map.MapViewModel
import c.bmartinez.fayucafinder.DataInjection.ViewModelFactory
import c.bmartinez.fayucafinder.View.login.LoginViewModel
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