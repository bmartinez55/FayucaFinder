package c.bmartinez.fayucafinder.Components

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import c.bmartinez.fayucafinder.View.map.MapsFragment
import c.bmartinez.fayucafinder.ViewModel.Modules.MyViewModelModule
import c.bmartinez.fayucafinder.ViewModel.Modules.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ViewModelFactoryModule::class, MyViewModelModule::class])
interface MyComponents {
    fun inject(fragment: Fragment)
}