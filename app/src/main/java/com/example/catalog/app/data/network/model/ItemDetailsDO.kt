package com.example.catalog.app.data.network.model

data class ItemDetailsDO(
    val elements: List<ProductElement>
)

data class ProductElement(
    val productId: String,
    val url: String,
    val shortName: String,
    val primaryImage: String,
    val has_options: String,
    val free_shipping: String
)