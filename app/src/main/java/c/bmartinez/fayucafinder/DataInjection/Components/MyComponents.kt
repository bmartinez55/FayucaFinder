package c.bmartinez.fayucafinder.DataInjection.Components

import android.app.Application
import androidx.fragment.app.Fragment
import c.bmartinez.fayucafinder.DataInjection.Module.MyViewModelModule
import c.bmartinez.fayucafinder.DataInjection.Module.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelFactoryModule::class, MyViewModelModule::class])
interface MyComponents {
    fun inject(fragment: Fragment)

    @Component.Factory
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): MyComponents
    }
}