package com.tcp.sephora.productlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.transform.CircleCropTransformation
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.imageloading.ShouldRefetchOnSizeChange
import com.tcp.sephora.data.models.ProductListEntry
import com.tcp.sephora.R
import com.tcp.sephora.ui.theme.RobotoCondensed
import java.util.*

@Composable
fun ProductListScreen(
    navController: NavController,
    viewModel: ProductListViewModel = hiltViewModel()
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            SearchBar(
                hint = "Search products...",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                viewModel.searchPokemonList(it)
            }
            Spacer(modifier = Modifier.height(16.dp))
            ProductList(navController = navController)
        }
    }
}

@Composable
fun ProductList(
    navController: NavController,
    viewModel: ProductListViewModel = hiltViewModel()
) {
    val productList by remember { viewModel.productList }
    val endReached by remember { viewModel.endReached }
    val loadError by remember { viewModel.loadError }
    val isLoading by remember { viewModel.isLoading }
    val isSearching by remember { viewModel.isSearching }

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        val itemCount = if(productList.size % 2 == 0) {
            productList.size / 2
        } else {
            productList.size / 2 + 1
        }
        items(itemCount) {
            if(it >= itemCount - 1 && !endReached && !isLoading && !isSearching) {
                viewModel.loadProductPaginated()
            }
            ProductRow(rowIndex = it, entries = productList, navController = navController)
        }
    }

    Box(
        contentAlignment = Center,
        modifier = Modifier.fillMaxSize()
    ) {
        if(isLoading) {
            CircularProgressIndicator(color = MaterialTheme.colors.primary)
        }
        if(loadError.isNotEmpty()) {
            RetrySection(error = loadError) {
                viewModel.loadProductPaginated()
            }
        }
    }

}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    Box(modifier = modifier) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(6.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged {
                    isHintDisplayed = !it.isFocused && text.isEmpty()
                }
        )
        if(isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }
    }
}

@Composable
fun ProductEntry(
    entry: ProductListEntry,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: ProductListViewModel = hiltViewModel()
) {
    Box(
        contentAlignment = Center,
        modifier = modifier
            .shadow(6.dp, RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(6.dp))
            .aspectRatio(1f)
            .background(Color.White)
            .clickable {
                val ROUTE_PRODUCT_DETAILS = "product_detail_screen/${entry.productName}/${entry.brandName}/${entry.productRating.toString()}/${entry.displayOriginalPrice}/${entry.displayDiscountPrice}/${entry.description.toString()}/${entry.imageUrl.toString()}"
                navController.navigate(
                    "product_detail_screen/${entry.productName}"
                )
            }
    ) {
        Column {
            Image(
                painter = rememberCoilPainter(
                    request = entry.imageUrl,
                    requestBuilder = {
                        transformations(CircleCropTransformation())
                    },
                    shouldRefetchOnSizeChange = ShouldRefetchOnSizeChange { _, _ -> true },
                    fadeIn = true,
                    previewPlaceholder = R.drawable.placeholder
                ),
                contentDescription = entry.productName,
                modifier = Modifier
                    .size(80.dp)
                    .align(CenterHorizontally)
            )
            Text(
                text = entry.brandName,
                fontFamily = RobotoCondensed,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
            )
            Text(
                text = entry.productName,
                fontFamily = RobotoCondensed,
                fontSize = 10.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
            )
            Text(
                text = "$" + entry.originalPrice.toString(),
                fontFamily = RobotoCondensed,
                fontSize = 10.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
            )
            Text(
                text = entry.productRating.toString(),
                fontFamily = RobotoCondensed,
                fontSize = 10.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
            )
            Text(
                text = entry.variantsCount.toString() + " variants",
                fontFamily = RobotoCondensed,
                fontSize = 10.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
            )
        }
    }
}

@Composable
fun ProductRow(
    rowIndex: Int,
    entries: List<ProductListEntry>,
    navController: NavController
) {
    Column {
        Row {
            ProductEntry(
                entry = entries[rowIndex * 2],
                navController = navController,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            if(entries.size >= rowIndex * 2 + 2) {
                ProductEntry(
                    entry = entries[rowIndex * 2 + 1],
                    navController = navController,
                    modifier = Modifier.weight(1f)
                )
            } else {
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun RetrySection(
    error: String,
    onRetry: () -> Unit
) {
    Column {
        Text(error, color = Color.Red, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { onRetry() },
            modifier = Modifier.align(CenterHorizontally)
        ) {
            Text(text = "Retry")
        }
    }
}