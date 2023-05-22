package com.jon.simracingpricechecker.data.datasource

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.jon.simracingpricechecker.domain.model.Product
import com.jon.simracingpricechecker.domain.model.ProductDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
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

    override fun getStockDetailsItems(productElement: Element): Flow<Product> = flow {
        // Fetch the product details
        val productUrl = productElement.selectFirst("a")?.attr("href")
        val productDoc: Document = Jsoup.connect(productUrl).get()
        val descriptionElement = productDoc.selectFirst("div.product-short-description")
        val inStockElement = productDoc.selectFirst("p.availability")
        val purchaseUrlElement = productDoc.selectFirst("a.button.product_type_external")

        Product(
            imageUrl = productElement.selectFirst("img")?.attr("src") ?: "",
            title = productElement.selectFirst("h2")?.text() ?: "",
            price = productElement.selectFirst("span.price")?.text() ?: "",
            detail = ProductDetail(
                description = descriptionElement?.text() ?: "",
                inStock = !inStockElement?.text()?.contains("Out of stock")!! ?: true,
                purchaseUrl = purchaseUrlElement?.attr("href") ?: ""
            )
        )
    }
}