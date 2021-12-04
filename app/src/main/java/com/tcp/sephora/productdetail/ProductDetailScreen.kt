package com.tcp.sephora.productdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.HtmlCompat
import androidx.navigation.NavController
import coil.transform.CircleCropTransformation
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.imageloading.ShouldRefetchOnSizeChange
import com.tcp.sephora.R
import com.tcp.sephora.ui.theme.RobotoCondensed
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun ProductDetailScreen(
    productName: String,
    brandName: String,
    productRating: String,
    displayOriginalPrice: String,
    displayDiscountPrice: String,
    imageUrl: String,
    description: String,
    productImageSize: Dp = 200.dp,
    navController: NavController,
    topPadding: Dp = 20.dp
) {
    val decodedDescription = URLDecoder.decode(description, StandardCharsets.UTF_8.toString())

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
        Image(
            painter = rememberCoilPainter(
                request = imageUrl,
                requestBuilder = {
                    transformations(CircleCropTransformation())
                },
                shouldRefetchOnSizeChange = ShouldRefetchOnSizeChange { _, _ -> true },
                fadeIn = true,
                previewPlaceholder = R.drawable.placeholder
            ),
            contentDescription = productName,
            modifier = Modifier
                .size(productImageSize)
                .align(TopCenter)
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
        Column(
            modifier = Modifier
                .padding(top = 116.dp)
        ){
            Text(
                text = URLDecoder.decode(brandName, StandardCharsets.UTF_8.toString()),
                fontFamily = RobotoCondensed,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Text(
                text = "Rating: $productRating",
                fontFamily = RobotoCondensed,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Text(
                text = "Original Price: $displayOriginalPrice",
                fontFamily = RobotoCondensed,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Text(
                text = "Discount Price: $displayDiscountPrice",
                fontFamily = RobotoCondensed,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Text(
                text = HtmlCompat.fromHtml(decodedDescription, HtmlCompat.FROM_HTML_MODE_LEGACY).toString(),
                fontFamily = RobotoCondensed,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
        }
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