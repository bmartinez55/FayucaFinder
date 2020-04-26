package c.bmartinez.fayucafinder.DataInjection

import androidx.lifecycle.ViewModelProvider
import c.bmartinez.fayucafinder.DataInjection.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule{
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}
