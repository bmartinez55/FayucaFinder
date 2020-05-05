package c.bmartinez.fayucafinder.DataInjection.Module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import c.bmartinez.fayucafinder.FayucaFinderApplication
import c.bmartinez.fayucafinder.View.map.MapViewState
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
//private val application: FayucaFinderApplication
@Module
class AppModule() {
    @Provides @Singleton
    fun provideApplication(application: Application) = application
    //abstract fun bindContext(application: Application): Context

}