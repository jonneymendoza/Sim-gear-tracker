package com.jon.simracingpricechecker.domain.usecase

import com.jon.simracingpricechecker.data.repository.AbruzziRepository
import com.jon.simracingpricechecker.domain.model.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAbruzziStockItems @Inject constructor(private val abruzziRepository: AbruzziRepository) {

    suspend operator fun invoke(): Flow<List<Product>> = abruzziRepository.getStockItems()

}