package c.bmartinez.fayucafinder.datainjection.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * AppModule allows separation of different types of dependencies and then link them to components.
 */

@Module
abstract class AppModule() {
    @Singleton
    @Provides
    fun checkDependencyReference(app: Application): Boolean {
        return app == null
    }
}