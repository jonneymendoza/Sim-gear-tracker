package com.jon.simracingpricechecker.di

import com.jon.simracingpricechecker.data.datasource.AbruzziDataStore
import com.jon.simracingpricechecker.data.datasource.AbruzziDataStoreImpl
import com.jon.simracingpricechecker.data.repository.AbruzziRepository
import com.jon.simracingpricechecker.data.repository.AbruzziRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    fun bindAbruzziDataStore(): AbruzziDataStore {
        return AbruzziDataStoreImpl()
    }

    @Provides
    fun bindAbruzziRepository(abruzziDataStore: AbruzziDataStore): AbruzziRepository {
        return AbruzziRepositoryImpl(abruzziDataStore)
    }
}