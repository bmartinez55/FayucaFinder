package c.bmartinez.fayucafinder.datainjection.components

import android.app.Application
import c.bmartinez.fayucafinder.datainjection.module.*
import c.bmartinez.fayucafinder.FayucaFinderApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * AppComponent interface binds the Application instance to the component
 */

@Singleton
@Component(modules = [
    AppModule::class,
    ActivityBindingModule::class,
    AndroidSupportInjectionModule::class,
    ViewModelModule::class])
interface AppComponent: AndroidInjector<FayucaFinderApplication>{

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AppComponent
    }
}
