package c.bmartinez.fayucafinder.DataInjection.Components

import androidx.fragment.app.Fragment
import c.bmartinez.fayucafinder.DataInjection.Module.*
import c.bmartinez.fayucafinder.DataInjection.Scope.AppScoped
import c.bmartinez.fayucafinder.FayucaFinderApplication
import c.bmartinez.fayucafinder.View.map.MapsFragment
import dagger.Component
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
interface MyComponents{
    //: AndroidInjector<DaggerApplication>
    fun inject(context: FayucaFinderApplication)

//    @Component.Builder
//    interface Builder {
//
//        @BindsInstance
//        fun application(application: Application): Builder
//        fun build(): MyComponents
//
//    }
}
//
//@dagger.Module
//abstract class TestModule{
//    @ContributesAndroidInjector
//    abstract fun mapActivity(): MapActivity
//}