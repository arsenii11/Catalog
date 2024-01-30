package com.example.catalog.app.ui.catalog.itemslist

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.catalog.R
import com.example.catalog.app.ui.catalog.categories.MyTopAppBar
import net.marcoromano.catalog.app.ui.catalog.itemslist.ItemsListViewModel
import java.net.URLDecoder

@Composable
internal fun ItemsListScreen(navController: NavController, categoryName:String?, categoryId:String?) {

    val categoryNameDecoded = URLDecoder.decode(categoryName, "UTF-8");

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
                title = categoryNameDecoded?:"Items",
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
                                ItemsListItem(listItem ) {navController.navigate("details/${listItem.url}") }
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
                    Box(modifier = Modifier.fillMaxSize()){
                        CircularProgressIndicator(
                            modifier = Modifier
                                .padding(16.dp)
                                .align(Alignment.Center)
                                .size(50.dp),
                            color = MaterialTheme.colorScheme.primary
                        )}
                }
            }

        }
    }
}
@Composable
fun ItemsListItem(item: ItemsListUiState.Items.Item, onItemClicked: () -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onItemClicked()
        },
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 12.dp)
        ) {
            AsyncImage(
                modifier = Modifier.size(70.dp),
                model = "http://images1.opticsplanet.com/120-90-ffffff/${item.imageLink}",
                placeholder = painterResource(id = R.drawable.image_placeholder),
                error = painterResource(id = R.drawable.image_placeholder),
                contentDescription = "Logo of product",
            )


            // Spacer to add some space between image and text
            Spacer(modifier = Modifier.width(12.dp))

            // Column containing text elements
            Column {
                Text(
                    text = item.title ?: "No data",
                    modifier = Modifier
                        .fillMaxWidth(),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = item.price.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                )
            }
        }


    }
}