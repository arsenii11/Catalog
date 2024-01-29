package com.example.catalog.app.ui

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.catalog.app.ui.catalog.itemdetails.ItemDetailsFragment
import net.marcoromano.catalog.app.ui.catalog.categories.CategoriesScreen
import net.marcoromano.catalog.app.ui.catalog.itemslist.ItemsListScreen

object CatalogNavigation {
    const val CATEGORIES: String = "categories"
    const val ITEMS: String = "items"
    const val DETAILS: String = "details"

    fun navGraphBuilder(navGraphBuilder: NavGraphBuilder) {
        // Assuming you have corresponding Compose screens for ITEMS and DETAILS
        navGraphBuilder.composable(
            route = CATEGORIES,
        ) {
            CategoriesScreen(vm = viewModel())
        }
        navGraphBuilder.composable(
            route = ITEMS,
        ) {
            ItemsListScreen()
        }
        navGraphBuilder.composable(
            route = DETAILS,
        ) {
            ItemDetailsFragment()
        }
    }

    fun navigate(navController: NavController, destination: String) {
        navController.navigate(destination)
    }
}

