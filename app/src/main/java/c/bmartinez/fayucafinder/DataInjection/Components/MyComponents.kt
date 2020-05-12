package c.bmartinez.fayucafinder.DataInjection.Components

import android.app.Application
import c.bmartinez.fayucafinder.DataInjection.Module.*
import c.bmartinez.fayucafinder.FayucaFinderApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
    ActivityBindingModule::class,
    AndroidSupportInjectionModule::class,
    ViewModelModule::class,
    FirebaseRepositoryModule::class])
interface MyComponents{

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): MyComponents
    }

    fun inject(app: FayucaFinderApplication)
}
