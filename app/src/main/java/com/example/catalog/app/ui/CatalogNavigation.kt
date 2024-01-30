package com.example.catalog.app.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.catalog.app.ui.catalog.categories.CategoriesScreen
import com.example.catalog.app.ui.catalog.itemdetails.ItemDetailsScreen
import com.example.catalog.app.ui.catalog.itemslist.ItemsListScreen

object CatalogNavigation {
    const val CATEGORIES: String = "categories"
    const val ITEMS: String = "items/{categoryName}/{categoryId}"
    const val DETAILS: String = "details/{itemUrl}"

    fun navGraphBuilder(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        // Assuming you have corresponding Compose screens for ITEMS and DETAILS
        navGraphBuilder.composable(
            route = CATEGORIES,
        ) {
            CategoriesScreen(navController = navController)
        }
        navGraphBuilder.composable(
            route = ITEMS,
            arguments = listOf(
                navArgument("categoryName") { type = NavType.StringType },
                navArgument("categoryId") { type = NavType.StringType },
                )
        ) { backStackEntry ->
            // Access the category argument
            val categoryName: String? = backStackEntry.arguments?.getString("categoryName")
            val categoryId: String? = backStackEntry.arguments?.getString("categoryId")
            ItemsListScreen(navController = navController, categoryName = categoryName, categoryId = categoryId)
            // Items screen content with category
        }
        navGraphBuilder.composable(
            route = DETAILS,
            arguments = listOf(
                navArgument("itemUrl") { type = NavType.StringType },
            )
        ) {backStackEntry ->
            val itemId:String = backStackEntry.arguments?.getString("itemUrl").toString()
            ItemDetailsScreen(navController,itemId)
        }
    }
    fun navigate(navController: NavController, destination: String) {
        navController.navigate(route = destination)
    }

}

