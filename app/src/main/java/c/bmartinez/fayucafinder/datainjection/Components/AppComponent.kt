package c.bmartinez.fayucafinder.datainjection.Components

import android.app.Application
import c.bmartinez.fayucafinder.datainjection.Module.*
import c.bmartinez.fayucafinder.FayucaFinderApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = [AppModule::class,
    ActivityBindingModule::class,
    AndroidSupportInjectionModule::class,
    ViewModelModule::class,
    FirebaseRepositoryModule::class])
@Singleton
interface AppComponent: AndroidInjector<FayucaFinderApplication>{

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}
