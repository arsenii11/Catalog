package com.example.catalog.app.domain

import com.example.catalog.app.data.network.api.CatalogApiClient
import com.example.catalog.app.data.network.model.ItemDetailsDO
import com.example.catalog.app.ui.catalog.itemdetails.ItemDetailsUiState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetItemDetailsUseCase @Inject constructor(private val apiService: CatalogApiClient) {
    suspend operator fun invoke(itemId:String): ItemDetailsUiState {
        return try {
            val response = apiService.getItemData(itemId)
            if (response.isSuccessful) {
                response.body()?.toItemDetailsUiState() ?: ItemDetailsUiState.Error("Empty response")
            } else {
                ItemDetailsUiState.Error("Failed to fetch categories")
            }
        } catch (e: Exception) {
            ItemDetailsUiState.Error(e.message ?: "An error occurred")
        }
    }

    private fun ItemDetailsDO.toItemDetailsUiState(): ItemDetailsUiState.Item {
        return ItemDetailsUiState.Item(
            productName = fullName,
            shortName = shortName,
            imageUrl = primaryImage,
            price = price.toString(),
            description = description
        )
    }

}