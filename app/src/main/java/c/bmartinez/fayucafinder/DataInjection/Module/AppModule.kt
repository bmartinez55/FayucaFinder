package c.bmartinez.fayucafinder.DataInjection.Module

import android.app.Application
import c.bmartinez.fayucafinder.FayucaFinderApplication
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
//private val application: FayucaFinderApplication
@Module(includes = [ActivityBindingModule::class])
abstract class AppModule() {
    @Provides
    abstract fun provideApplication(application: FayucaFinderApplication)
    //abstract fun bindContext(application: Application): Context

}