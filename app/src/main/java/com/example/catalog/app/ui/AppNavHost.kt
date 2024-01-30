package com.example.catalog.app.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost() {
  val navController = rememberNavController()
  NavHost(
    navController = navController,
    startDestination = CatalogNavigation.CATEGORIES,
    modifier = Modifier.fillMaxSize(),
  ) {
    CatalogNavigation.navGraphBuilder(this, navController)
  }
}
