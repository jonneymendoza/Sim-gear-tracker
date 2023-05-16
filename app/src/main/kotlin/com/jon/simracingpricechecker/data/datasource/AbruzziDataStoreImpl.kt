package com.jon.simracingpricechecker.data.datasource

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class AbruzziDataStoreImpl : AbruzziDataStore {

    private val _productsElement: MutableState<Elements> = mutableStateOf(Elements())
    val productsElement: State<Elements> = _productsElement

    override fun getStockItems(): Flow<Elements> = flow {
        val url = "https://abruzzi-official.co.uk/product-category/wheelbase-steering-wheels/"
        val doc: Document = Jsoup.connect(url).get()
        _productsElement.value = doc.select("li.product")
        emit(doc.select("li.product"))
    }
}