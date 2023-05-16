package com.jon.simracingpricechecker.domain.model

data class Product(
    val imageUrl: String,
    val title: String,
    val price: String,
    var detail: ProductDetail? = null
)
