package c.bmartinez.fayucafinder.DataInjection.Module

import c.bmartinez.fayucafinder.Model.Database.FireRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FirebaseRepositoryModule {
    @Provides
    fun provideFirebaseRepository(): FireRepository = FireRepository()
}