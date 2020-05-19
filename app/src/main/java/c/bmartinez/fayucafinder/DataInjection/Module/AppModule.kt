package c.bmartinez.fayucafinder.DataInjection.Module

import android.app.Application
import c.bmartinez.fayucafinder.FayucaFinderApplication
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.annotation.Nullable
import javax.inject.Singleton
//private val application: FayucaFinderApplication
@Module
class AppModule() {
    @Provides
    @Singleton
    fun provideApplication(application: FayucaFinderApplication): Application {
        return application
    }
    //abstract fun bindContext(application: Application): Context

}