package com.example.catalog.app.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.catalog.app.ui.catalog.itemdetails.ItemDetailsFragment
import com.example.catalog.app.ui.catalog.categories.CategoriesScreen
import com.example.catalog.app.ui.catalog.itemslist.ItemsListScreen

object CatalogNavigation {
    const val CATEGORIES: String = "categories"
    const val ITEMS: String = "items"
    const val DETAILS: String = "details"

    fun navGraphBuilder(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        // Assuming you have corresponding Compose screens for ITEMS and DETAILS
        navGraphBuilder.composable(
            route = CATEGORIES,
        ) {
            CategoriesScreen(navController = navController)
        }
        navGraphBuilder.composable(
            route = ITEMS,
        ) {
            ItemsListScreen(navController = navController)
        }
        navGraphBuilder.composable(
            route = DETAILS,
        ) {
            ItemDetailsFragment()
        }
    }
    fun navigate(navController: NavController, destination: String) {
        navController.navigate(route = destination)
    }
}

