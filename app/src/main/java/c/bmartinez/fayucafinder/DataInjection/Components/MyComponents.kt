package c.bmartinez.fayucafinder.DataInjection.Components

import android.app.Application
import androidx.fragment.app.Fragment
import c.bmartinez.fayucafinder.DataInjection.Module.*
import c.bmartinez.fayucafinder.DataInjection.Scope.AppScoped
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@AppScoped
@Component(modules = [AppModule::class,
    ActivityBindingModule::class,
    AndroidSupportInjectionModule::class,
    ViewModelModule::class,
    FirebaseRepositoryModule::class,
    ViewStateModule::class])
interface MyComponents : AndroidInjector<Application>{
    //fun inject(app: Application)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder
        fun build(): MyComponents

    }
}