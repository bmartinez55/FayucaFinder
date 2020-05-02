package c.bmartinez.fayucafinder.DataInjection.Module

import c.bmartinez.fayucafinder.Base.ViewState
import c.bmartinez.fayucafinder.DataInjection.Scope.AppScoped
import c.bmartinez.fayucafinder.View.map.MapViewState
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ViewStateModule {
    @Binds abstract fun provideViewState(viewState: MapViewState): ViewState

    @Module
    companion object{
        @Provides
        @JvmStatic
        fun provideMapViewState(): MapViewState = MapViewState()
    }


}