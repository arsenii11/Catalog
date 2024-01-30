package com.example.catalog.app.domain

import android.util.Log
import com.example.catalog.app.data.network.api.CatalogApiClient
import com.example.catalog.app.data.network.model.CategoryDO
import com.example.catalog.app.data.network.model.ItemsDO
import com.example.catalog.app.ui.catalog.categories.CategoriesUiState
import com.example.catalog.app.ui.catalog.itemslist.ItemsListUiState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetItemsListUseCase @Inject constructor(private val apiService: CatalogApiClient) {
 /*   suspend operator fun invoke(): ItemsListUiState {
        return try {
            val response = apiService.getItems("")
            if (response.isSuccessful) {
                response.body()?.toItemsListUiState() ?: ItemsListUiState.Error("Empty response")
            } else {
                ItemsListUiState.Error("Failed to fetch categories")
            }
        } catch (e: Exception) {
            ItemsListUiState.Error(e.message ?: "An error occurred")
        }
    }

    private fun ItemsDO.toItemsListUiState(): ItemsListUiState.Item {
        return  ItemsListUiState.Item( )}*/

}