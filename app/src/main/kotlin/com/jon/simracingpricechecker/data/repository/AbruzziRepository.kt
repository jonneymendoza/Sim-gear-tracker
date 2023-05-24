package com.jon.simracingpricechecker.data.repository

import com.jon.simracingpricechecker.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface AbruzziRepository {
    suspend fun getStockItems(): Flow<List<Product>>
}