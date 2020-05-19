package c.bmartinez.fayucafinder

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import c.bmartinez.fayucafinder.DataInjection.Components.DaggerMyComponents
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

@SuppressLint("Registered")
class FayucaFinderApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerMyComponents.builder().application(this).build()
    }
}

