package net.marcoromano.catalog.app.domain

import net.marcoromano.catalog.app.data.network.api.CatalogApiClient
import com.example.catalog.app.ui.catalog.CategoryUiState
import net.marcoromano.catalog.app.data.network.model.CategoryDO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetCategoriesUseCase @Inject constructor(private val apiService: CatalogApiClient) {


    suspend operator fun invoke(): CategoryUiState {
        return try {
            val response = apiService.getCategories()
            if (response.isSuccessful) {
                response.body()?.toCategoryUiState() ?: CategoryUiState.Error("Empty response")
            } else {
                CategoryUiState.Error("Failed to fetch categories")
            }
        } catch (e: Exception) {
            CategoryUiState.Error(e.message ?: "An error occurred")
        }
    }

    private fun CategoryDO.toCategoryUiState(): CategoryUiState.Categories {
        return CategoryUiState.Categories(
            categories = categories.map { categoryData ->
                CategoryUiState.Categories.Category(
                    name = categoryData.short_name,
                    id = categoryData.category_id
                )
            }
        )
    }

}