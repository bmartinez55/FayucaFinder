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

@Module
class AppModule(private val application: FayucaFinderApplication) {
    @Provides @Singleton
    fun provideApplication() = application
//    fun provideApplication(application: FayucaFinderApplication): SharedPreferences? {
//        return application.getSharedPreferences("store", Context.MODE_PRIVATE)
//    }
    //abstract fun bindContext(application: Application): Context

}