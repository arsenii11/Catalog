package net.marcoromano.catalog.app.domain

import android.util.Log
import com.example.catalog.app.ui.catalog.categories.CategoriesUiState
import com.example.catalog.app.data.network.api.CatalogApiClient
import com.example.catalog.app.data.network.model.CategoryDO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetCategoriesUseCase @Inject constructor(private val apiService: CatalogApiClient) {
    suspend operator fun invoke(): CategoriesUiState {
        return try {
            val response = apiService.getCategories()
            Log.d("JsonResponse", "JSON Response: $response")

            if (response.isSuccessful) {
                response.body()?.toCategoryUiState() ?: CategoriesUiState.Error("Empty response")
            } else {
                CategoriesUiState.Error("Failed to fetch categories")
            }
        } catch (e: Exception) {
            CategoriesUiState.Error(e.message ?: "An error occurred")
        }
    }

    private fun List<CategoryDO>.toCategoryUiState(): CategoriesUiState.Categories {
        return CategoriesUiState.Categories(
            categories = this.map { categoryData ->
                CategoriesUiState.Categories.Category(
                    name = categoryData.short_name,
                    url = categoryData.url
                )
            }
        )
    }
}
