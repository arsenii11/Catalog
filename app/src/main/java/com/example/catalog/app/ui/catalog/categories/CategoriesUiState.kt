package com.example.catalog.app.ui.catalog.categories

sealed class CategoriesUiState {

    data class Categories(
        val categories: List<Category>
    ): CategoriesUiState() {
        data class Category(
            val name: String,
            val id: String
        )
    }

    data class Error(
        val errorMessage: String
    ) : CategoriesUiState()
}