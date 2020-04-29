package c.bmartinez.fayucafinder.DataInjection.Module

import androidx.lifecycle.ViewModelProvider
import c.bmartinez.fayucafinder.DataInjection.Factory.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule{
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}
