package com.tcp.sephora.productdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tcp.sephora.ui.theme.RobotoCondensed
import timber.log.Timber

@Composable
fun ProductDetailScreen(
    productName: String,
    navController: NavController,
    topPadding: Dp = 20.dp,
    productImageSize: Dp = 200.dp
) {
    Timber.tag("productName").v(productName)
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(bottom = 16.dp)
    ) {
        ProductDetailTopSection(
            navController = navController,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .align(Alignment.TopCenter)
        )
        Text(
            text = productName,
            fontFamily = RobotoCondensed,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 64.dp)
        )
    }
}

@Composable
fun ProductDetailTopSection(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = modifier
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color.Black,
                        Color.Transparent
                    )
                )
            )
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(36.dp)
                .offset(16.dp, 16.dp)
                .clickable {
                    navController.popBackStack()
                }
        )
    }
}