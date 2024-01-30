package com.example.catalog.app.domain

import com.example.catalog.app.data.network.api.CatalogApiClient
import com.example.catalog.app.data.network.model.GridProducts
import com.example.catalog.app.ui.catalog.categories.CategoriesUiState
import com.example.catalog.app.ui.catalog.itemslist.ItemsListUiState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetItemsListUseCase @Inject constructor(private val apiService: CatalogApiClient) {
suspend operator fun invoke(): ItemsListUiState {
        return try {
            val response = apiService.getItems("177-air-rifle-pellets")
            if (response.isSuccessful) {
                response.body()?.gridProducts?.elements?.toItemsListUiState() ?: ItemsListUiState.Error("Empty response")
            } else {
                ItemsListUiState.Error("Failed to fetch categories")
            }
        } catch (e: Exception) {
            ItemsListUiState.Error(e.message ?: "An error occurred")
        }
    }

    private fun List<GridProducts.Elements>.toItemsListUiState(): ItemsListUiState.Items {
        return ItemsListUiState.Items(
            items = this.map { itemsData ->
                ItemsListUiState.Items.Item(
                    title = itemsData.fullName,
                    imageLink = itemsData.primaryImage,
                    price = itemsData.price
                )
            }
        )
    }

}