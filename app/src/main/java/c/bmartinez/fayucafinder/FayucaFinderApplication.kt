package c.bmartinez.fayucafinder

import android.app.Application
import c.bmartinez.fayucafinder.DataInjection.Components.DaggerMyComponents
import c.bmartinez.fayucafinder.DataInjection.Components.MyComponents
import c.bmartinez.fayucafinder.DataInjection.Module.AppModule

class FayucaFinderApplication: Application(){
    private val components: MyComponents by lazy {
        DaggerMyComponents.builder().appModule(AppModule(this)).build()
    }

    override fun onCreate() {
        super.onCreate()
        components.inject(this)
    }
}