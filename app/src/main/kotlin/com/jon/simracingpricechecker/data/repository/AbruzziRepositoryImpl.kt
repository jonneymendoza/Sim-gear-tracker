package com.jon.simracingpricechecker.data.repository

import com.jon.simracingpricechecker.data.datasource.AbruzziDataStore
import com.jon.simracingpricechecker.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AbruzziRepositoryImpl(val abruzziDataStore: AbruzziDataStore) : AbruzziRepository {
    override fun getStockItems(): Flow<List<Product>> {
        abruzziDataStore.getStockItems().map {

        }
    }
}