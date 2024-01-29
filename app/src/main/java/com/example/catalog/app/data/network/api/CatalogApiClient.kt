package net.marcoromano.catalog.app.data.network.api

import net.marcoromano.catalog.app.data.network.model.CategoryDO
import net.marcoromano.catalog.app.data.network.model.ItemsDO
import net.marcoromano.catalog.app.data.utilities.Links
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


interface CatalogApiClient {
    suspend fun getCategories(): Response<CategoryDO>
    suspend fun getItems(token: String): List<ItemsDO>
    suspend fun getItemData(token: String, itemId: String): ItemsDO
}

@Singleton
class CatalogApiManager @Inject constructor(
    private val retrofitRequest: RetrofitInstance,
) : CatalogApiClient {
    override suspend fun getCategories(): Response<CategoryDO> {
        return retrofitRequest.api.getCategories()
    }

    override suspend fun getItems(token: String): List<ItemsDO> {
        TODO("Not yet implemented")
    }

    override suspend fun getItemData(token: String, itemId: String): ItemsDO {
        TODO("Not yet implemented")
    }
}
