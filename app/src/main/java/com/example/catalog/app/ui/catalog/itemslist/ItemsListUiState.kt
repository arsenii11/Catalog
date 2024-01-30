package com.example.catalog.app.ui.catalog.itemslist

sealed class ItemsListUiState {


    data class Items(
        val items: List<Item>
    ): ItemsListUiState() {
    data class Item(
        val title: String?,
        val imageLink: String?,
        val price: Double?,
    ): ItemsListUiState()
    }

    data class Error(
        val errorMessage: String
    ) : ItemsListUiState()
}