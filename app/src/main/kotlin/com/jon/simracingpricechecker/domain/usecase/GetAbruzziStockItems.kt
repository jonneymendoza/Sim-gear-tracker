package com.jon.simracingpricechecker.domain.usecase

import com.jon.simracingpricechecker.data.repository.AbruzziRepository
import com.jon.simracingpricechecker.domain.model.Product
import kotlinx.coroutines.flow.Flow

class GetAbruzziStockItems(val abruzziRepository: AbruzziRepository) {

    fun getItems(): Flow<List<Product>> {
        return abruzziRepository.getStockItems()
    }

}