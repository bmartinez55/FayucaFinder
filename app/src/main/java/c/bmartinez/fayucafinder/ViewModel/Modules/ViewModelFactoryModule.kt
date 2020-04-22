package c.bmartinez.fayucafinder.ViewModel.Modules

import androidx.lifecycle.ViewModelProvider
import c.bmartinez.fayucafinder.ViewModel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule{
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}