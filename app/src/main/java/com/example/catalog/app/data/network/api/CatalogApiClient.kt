package com.example.catalog.app.data.network.api

import android.util.Log
import com.example.catalog.app.data.network.model.CategoryDO
import com.example.catalog.app.data.network.model.ItemsDO
import net.marcoromano.catalog.app.data.network.model.ItemDetailsDO
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


interface CatalogApiClient {
    suspend fun getCategories():  Response<List<CategoryDO>>
    suspend fun getItems(identifier: String): Response<ItemsDO>
    suspend fun getItemData(identifier: String): Response<ItemDetailsDO>
}

@Singleton
class CatalogApiManager @Inject constructor(
    private val retrofitRequest: RetrofitInstance,
) : CatalogApiClient {
    override suspend fun getCategories(): Response<List<CategoryDO>> {
        return retrofitRequest.api.getCategories()
    }

    override suspend fun getItems(identifier: String): Response<ItemsDO> {
        return retrofitRequest.api.getItems(identifier = identifier)
    }

    override suspend fun getItemData(identifier: String): Response<ItemDetailsDO>{
      return retrofitRequest.api.getItemData(identifier = identifier)
    }
}
