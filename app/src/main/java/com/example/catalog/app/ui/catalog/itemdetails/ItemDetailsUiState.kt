package com.example.catalog.app.ui.catalog.itemdetails

sealed class ItemDetailsUiState {

    data class Item(
        val productName: String,
        val shortName: String,
        val imageUrl: String,
        val price: String,
        val description: String,
    ): ItemDetailsUiState()

    data class Error(
        val errorMessage: String
    ) : ItemDetailsUiState()
}