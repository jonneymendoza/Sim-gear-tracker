package com.jon.simracingpricechecker.data.repository

import com.jon.simracingpricechecker.data.datasource.AbruzziDataStore
import com.jon.simracingpricechecker.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AbruzziRepositoryImpl @Inject constructor(val abruzziDataStore: AbruzziDataStore) :
    AbruzziRepository {
    override suspend fun getStockItems(): Flow<List<Product>> = flow {
        abruzziDataStore.getStockItems().collect { products ->
            val productLIst = mutableListOf<Product>()

            for (productElement in products) {
                abruzziDataStore.getStockDetailsItems(productElement).collect { product ->
                    productLIst.add(product)
                }
            }
            emit(productLIst)
        }
    }
}