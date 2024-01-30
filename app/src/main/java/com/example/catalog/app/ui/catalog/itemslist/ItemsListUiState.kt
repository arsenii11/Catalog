package com.example.catalog.app.ui.catalog.itemslist

import android.app.ActivityManager.TaskDescription

sealed class ItemsListUiState {

    data class Item(
        val title: String,
        val imageLink: String,
        val price: String,
    ): ItemsListUiState()

    data class Error(
        val errorMessage: String
    ) : ItemsListUiState()
}