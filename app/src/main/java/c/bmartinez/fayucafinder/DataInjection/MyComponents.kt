package c.bmartinez.fayucafinder.DataInjection

import androidx.fragment.app.Fragment
import dagger.Component

@Component(modules = [ViewModelFactoryModule::class, MyViewModelModule::class])
interface MyComponents {
    fun inject(fragment: Fragment)
}