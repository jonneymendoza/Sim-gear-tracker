package com.jon.simracingpricechecker.di

import com.jon.simracingpricechecker.data.datasource.AbruzziDataStore
import com.jon.simracingpricechecker.data.datasource.AbruzziDataStoreImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object DomainModule {

    @Provides
    fun bindAbruzziDataStore() : AbruzziDataStore {
        return AbruzziDataStoreImpl()
    }
}