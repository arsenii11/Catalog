package com.example.catalog.app.ui.catalog.itemslist

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.catalog.R
import com.example.catalog.app.ui.catalog.categories.CategoriesListItem
import com.example.catalog.app.ui.catalog.categories.MyTopAppBar
import net.marcoromano.catalog.app.ui.catalog.itemslist.ItemsListViewModel

@Composable
internal fun ItemsListScreen(navController: NavController, categoryName:String?, categoryId:String?) {
    val vm = hiltViewModel<ItemsListViewModel>()
    val uiState by vm.myResponse.observeAsState()

    // Fetch data when the screen is first created
    LaunchedEffect(Unit) {
        try {
            if (categoryId != null) {
                vm.fetchData(categoryId)
            }
        } catch (e: Exception) {
            Log.e("YourTag", "Error in LaunchedEffect: ${e.message}", e)
        }
    }

    Scaffold(
        topBar = {
            MyTopAppBar(
                title = categoryName?:"Items",
                onNavigateUp = { navController.navigateUp() })
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Render content based on the data state
            when (uiState) {
                is ItemsListUiState.Items -> {
                    val items = (uiState as ItemsListUiState.Items).items

                    // Render your UI based on the list of categories
                    LazyColumn {
                        items.forEach { listItem ->
                            item {
                                CategoriesListItem(listItem.title ?: "No name") { }
                            }
                        }
                    }
                }

                is ItemsListUiState.Error -> {
                    val errorMessage = (uiState as ItemsListUiState.Error).errorMessage

                    // Handle error state if needed
                    Text(text = errorMessage)
                }

                else -> {
                    Box(modifier = Modifier.fillMaxSize()) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .padding(16.dp)
                                .align(Alignment.Center)
                                .size(50.dp),
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

        }
    }
}