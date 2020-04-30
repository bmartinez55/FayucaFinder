package c.bmartinez.fayucafinder.DataInjection.Module

import c.bmartinez.fayucafinder.DataInjection.Scope.AppScoped
import c.bmartinez.fayucafinder.Model.Database.FireRepository
import dagger.Module
import dagger.Provides

@Module
class FirebaseRepositoryModule {
    @Provides
    @AppScoped
    fun provideFirebaseRepository(): FireRepository = FireRepository()
}