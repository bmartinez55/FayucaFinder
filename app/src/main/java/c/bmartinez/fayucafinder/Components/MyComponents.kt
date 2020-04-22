package c.bmartinez.fayucafinder.Components

import androidx.fragment.app.Fragment
import c.bmartinez.fayucafinder.View.map.MapsFragment
import c.bmartinez.fayucafinder.ViewModel.Modules.MyViewModelModule
import c.bmartinez.fayucafinder.ViewModel.Modules.ViewModelFactoryModule
import dagger.Component

@Component(modules = [ViewModelFactoryModule::class,MyViewModelModule::class])
interface MyComponents: {
    fun inject(fragment: Fragment)
}