package c.bmartinez.fayucafinder

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import c.bmartinez.fayucafinder.DataInjection.Components.DaggerMyComponents
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

@SuppressLint("Registered")
class FayucaFinderApplication: Application(), HasActivityInjector{
    @Inject
    lateinit var androidInjectorFactory: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerMyComponents.builder().application(this).build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity>? {return androidInjectorFactory }
}

