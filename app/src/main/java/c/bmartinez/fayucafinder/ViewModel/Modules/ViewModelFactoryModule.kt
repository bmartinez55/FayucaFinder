package c.bmartinez.fayucafinder.ViewModel.Modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import c.bmartinez.fayucafinder.ViewModel.MapViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Inject

@Module
abstract class ViewModelFactoryModule{
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}
