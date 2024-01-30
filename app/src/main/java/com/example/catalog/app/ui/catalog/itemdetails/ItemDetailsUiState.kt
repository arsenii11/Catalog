package com.example.catalog.app.ui.catalog.itemdetails

import android.app.ActivityManager.TaskDescription

sealed class ItemDetailsUiState {

    data class Item(
        val productName: String,
        val imageLink: String,
        val price: String,
        val description: String,
    ): ItemDetailsUiState()

    data class Error(
        val errorMessage: String
    ) : ItemDetailsUiState()
}