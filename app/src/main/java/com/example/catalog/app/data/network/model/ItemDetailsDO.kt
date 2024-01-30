package com.example.catalog.app.data.network.model

import com.google.gson.annotations.SerializedName

data class ItemDetailsDO(
    @SerializedName("full_name") var fullName: String = "",
    @SerializedName("short_name") var shortName: String = "",
    @SerializedName("primary_image") var primaryImage:  String = "",
    @SerializedName("min_sale_price") var price: Double = 0.0,
    @SerializedName("description") var description: String = "",
)