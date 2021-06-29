package c.bmartinez.fayucafinder

import c.bmartinez.fayucafinder.datainjection.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class FayucaFinderApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerAppComponent.factory().create(this)
    }

}

