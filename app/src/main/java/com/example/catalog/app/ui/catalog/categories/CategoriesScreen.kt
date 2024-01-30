package com.example.catalog.app.ui.catalog.categories

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.catalog.R
import androidx.compose.material3.IconButton as IconButton1


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    title: String,
    onNavigateUp: () -> Unit
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = { onNavigateUp() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        }
    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CategoriesScreen(navController: NavController) {
  val vm = hiltViewModel<CategoriesViewModel>()
  val uiState by vm.myResponse.observeAsState()

  // Fetch data when the screen is first created
  LaunchedEffect(Unit) {
    vm.fetchData()
  }
  Scaffold(
    topBar = {
      TopAppBar(title = { Text(text = stringResource(R.string.top_bar_name)) })
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
          is CategoriesUiState.Categories -> {
            val categories = (uiState as CategoriesUiState.Categories).categories

            // Render your UI based on the list of categories
            LazyColumn {
             categories.forEach{ listItem ->
                item {
                    CategoriesListItem(listItem.name) { navController.navigate("items/${listItem.name}/${listItem.url}") }
                }
              }
            }
          }
          is CategoriesUiState.Error -> {
            val errorMessage = (uiState as CategoriesUiState.Error).errorMessage

            // Handle error state if needed
            Text(text = errorMessage)
          }
          else -> {
              Box(modifier = Modifier.fillMaxSize()){
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
  }}



@Composable
fun CategoriesListItem(item: String, onItemClicked: () -> Unit) {
  Row(modifier = Modifier
      .fillMaxWidth()
      .clickable {
          onItemClicked()
      },
    horizontalArrangement = Arrangement.SpaceBetween,
  ) {
  Text(text = item, modifier = Modifier.padding(16.dp))
}
}

@Preview(name = "Day mode")
@Preview(name = "Night mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Preview() {
    val navController = rememberNavController()
  CategoriesScreen(navController = navController)
}

@Composable
private fun ListElementPreview() {
 CategoriesListItem(item = "Ammo") {}
}

