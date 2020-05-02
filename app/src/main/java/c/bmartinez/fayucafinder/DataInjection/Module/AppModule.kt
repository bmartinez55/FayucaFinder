package c.bmartinez.fayucafinder.DataInjection.Module

import android.app.Application
import android.content.Context
import c.bmartinez.fayucafinder.View.map.MapViewState
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {
    @Provides @Singleton
    fun provideApplication() = app
    //abstract fun bindContext(application: Application): Context

}