package com.example.catalog.app.ui.catalog

sealed class CategoryUiState {

    data class Categories(
        val categories: List<Category>
    ): CategoryUiState() {
        data class Category(
            val name: String,
            val id: String
        )
    }

    data class Error(
        val errorMessage: String
    ) : CategoryUiState()
}