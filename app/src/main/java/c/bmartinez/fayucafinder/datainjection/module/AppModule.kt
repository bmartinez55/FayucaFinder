package c.bmartinez.fayucafinder.datainjection.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * AppModule allows app-level dependencies that do not fall into any category to be added.
 */

@Module
abstract class AppModule() {
    @Singleton
    @Provides
    fun checkDependencyReference(app: Application): Boolean {
        return app == null
    }
}