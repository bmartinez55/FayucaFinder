package c.bmartinez.fayucafinder

import android.annotation.SuppressLint
import android.app.Application
import c.bmartinez.fayucafinder.DataInjection.Components.DaggerMyComponents
import c.bmartinez.fayucafinder.DataInjection.Components.MyComponents
import c.bmartinez.fayucafinder.DataInjection.Module.AppModule
import dagger.android.DaggerApplication

@SuppressLint("Registered")
class FayucaFinderApplication: Application(){
//    private val components: MyComponents by lazy{
//        DaggerMyComponents.builder().application(this).build()
//    }
    companion object {@JvmStatic lateinit var components: MyComponents}

    override fun onCreate() {
        super.onCreate()
        components = DaggerMyComponents.builder().appModule(AppModule(this)).build()
        components.inject(this)
    }
}

