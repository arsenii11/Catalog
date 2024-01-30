package com.example.catalog.app.ui.catalog.itemdetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.catalog.R
import com.example.catalog.app.ui.catalog.categories.MyTopAppBar
import com.example.catalog.app.ui.catalog.itemslist.ItemsListUiState
import net.marcoromano.catalog.app.ui.catalog.itemslist.ItemsListViewModel
import org.jsoup.Jsoup
import org.jsoup.nodes.Document


@Composable
internal fun ItemDetailsScreen(navController: NavController, itemId:String?) {
    val vm = hiltViewModel<ItemDetailsViewModel>()
    val uiState by vm.myResponse.observeAsState()

    // Fetch data when the screen is first created
    LaunchedEffect(Unit) {
        try {
            if (itemId != null) {
                vm.fetchData(itemId)
            }
        } catch (e: Exception) {
            Log.e("YourTag", "Error in LaunchedEffect: ${e.message}", e)
        }
    }

    Scaffold(
        topBar = {
            MyTopAppBarHome(
                title = "",
                onNavigateUp = { navController.navigateUp() },
                onGoHome = {navController.popBackStack("categories", inclusive = false)})
        },
    ) { paddingValues ->
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Render content based on the data state
            when (uiState) {
                is ItemDetailsUiState.Item -> {
                    val item = (uiState as ItemDetailsUiState.Item)

                    val document: Document = Jsoup.parse(item.description)
                    // Extracting text from specific HTML elements
                    val description = document.select("#product-caption-block-description").text()
                    val manufacturer = document.select(".spec-table td:contains(Manufacturer) + td").text()
                    val cartridge = document.select(".spec-table td:contains(Cartridge) + td").text()
                    val numberOfRounds = document.select(".spec-table td:contains(Number of Rounds) + td").text()


                    AsyncImage(
                        modifier = Modifier.size(200.dp),
                        model = "http://images1.opticsplanet.com/365-240-ffffff/${item.imageUrl}.jpg",
                        placeholder = painterResource(id = R.drawable.image_placeholder),
                        error = painterResource(id = R.drawable.image_placeholder),
                        contentDescription = "Logo of product",
                    )

                    // Product details - Name, Price, Description
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Text(text = item.productName, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Price: ${item.price}", fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = description, fontSize = 16.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = manufacturer, fontSize = 16.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = cartridge, fontSize = 16.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = numberOfRounds, fontSize = 16.sp)
                    }
                }
                is ItemDetailsUiState.Error -> {
                    val errorMessage = (uiState as ItemDetailsUiState.Error).errorMessage

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarHome(
    title: String,
    onNavigateUp: () -> Unit,
    onGoHome: () -> Unit
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = { onNavigateUp() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(onClick = { onGoHome() }) {
                Icon(Icons.Default.Home, contentDescription = "Go Home")
            }
        }
    )
}
