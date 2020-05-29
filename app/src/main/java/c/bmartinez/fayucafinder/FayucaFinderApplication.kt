package c.bmartinez.fayucafinder

import c.bmartinez.fayucafinder.DataInjection.Components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class FayucaFinderApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerAppComponent.builder().application(this).build()
    }

}

