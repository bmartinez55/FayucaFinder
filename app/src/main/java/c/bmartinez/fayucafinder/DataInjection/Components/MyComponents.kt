package c.bmartinez.fayucafinder.DataInjection.Components

import android.app.Application
import androidx.fragment.app.Fragment
import c.bmartinez.fayucafinder.DataInjection.Module.ActivityBindingModule
import c.bmartinez.fayucafinder.DataInjection.Module.AppModule
import c.bmartinez.fayucafinder.DataInjection.Module.FirebaseRepositoryModule
import c.bmartinez.fayucafinder.DataInjection.Module.ViewModelModule
import c.bmartinez.fayucafinder.DataInjection.Scope.AppScoped
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@AppScoped
@Component(modules = [AppModule::class,
    ActivityBindingModule::class,
    AndroidSupportInjectionModule::class,
    ViewModelModule::class,
    FirebaseRepositoryModule::class])
interface MyComponents: AndroidInjector<Application> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): MyComponents
    }
    //fun inject(fragment: Fragment)

}