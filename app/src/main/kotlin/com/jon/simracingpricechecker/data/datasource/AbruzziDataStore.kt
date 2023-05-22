package com.jon.simracingpricechecker.data.datasource

import com.jon.simracingpricechecker.domain.model.Product
import kotlinx.coroutines.flow.Flow
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

interface AbruzziDataStore {
    fun getStockItems(): Flow<Elements>
    fun getStockDetailsItems(productElement: Element): Flow<Product>
}