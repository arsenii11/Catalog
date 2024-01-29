package net.marcoromano.catalog.app.ui.catalog.categories

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.fragment.app.viewModels
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.catalog.R
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.catalog.app.ui.catalog.categories.CategoriesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CategoriesScreen() {
  val vm = hiltViewModel<CategoriesViewModel>()

  // Access ViewModel properties or functions as needed
  val loadingState by vm.loadingState.observeAsState()
  val errorState by vm.errorState.observeAsState()
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
      if (loadingState == true) {
        CircularProgressIndicator()
      } else {
        // Handle error state
        errorState?.let {
          // Show error message
          Text(text = it)
        }
        
        Text(text = "SVGHhjb")

        // Render content based on the data state
    /*    vm.myResponse.value?.let { categoryUiState ->
          when (categoryUiState) {
            is CategoryUiState.Categories -> {
              // Render your UI based on the success state
              // For example, display a LazyColumn with the data
              LazyColumn {
                // Iterate through the list and create a Text composable for each item
                items(itemList) { item ->
                  ListItem(item = item)
                }
              }
              }
            }
            is CategoryUiState.Error -> {
              // Handle error state if needed
            }
            // Add other states as needed
          }*/
        }
      }
    }
  }



@Composable
fun ListItem(item: String) {
  Text(text = item, modifier = Modifier.padding(16.dp))
}

@Preview(name = "Day mode")
@Preview(name = "Night mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Preview() {
  CategoriesScreen(
  )
}
