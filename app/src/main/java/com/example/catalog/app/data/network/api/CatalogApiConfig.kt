package com.example.catalog.app.data.network.api

import com.example.catalog.app.data.network.model.CategoryDO
import com.example.catalog.app.data.network.model.ItemsDO
import com.example.catalog.app.data.network.model.ItemDetailsDO
import net.marcoromano.catalog.app.data.utilities.Links
import retrofit2.Response
import retrofit2.http.*


interface CatalogApiConfig {
    @GET(Links.CATEGORIES_URL)
    suspend fun getCategories(
        @Header("x-apikey") token: String = Links.API_KEY,
    ):  Response<List<CategoryDO>>


    @GET(Links.LIST_URL)
    suspend fun getItems(
        @Header("x-apikey") token: String = Links.API_KEY,
        @Path("identifier") identifier: String
    ): Response<ItemsDO>


    @GET(Links.ITEM_URL)
    suspend fun getItemData(
        @Header("x-apikey") token: String = Links.API_KEY,
        @Header("identifier") identifier: String,
    ): Response<ItemDetailsDO>
}