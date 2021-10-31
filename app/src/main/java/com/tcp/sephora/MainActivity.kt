package com.tcp.sephora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tcp.sephora.productdetail.ProductDetailScreen
import com.tcp.sephora.productlist.ProductListScreen
import com.tcp.sephora.ui.theme.SephoraTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SephoraTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "product_list_screen"
                ) {
                    composable("product_list_screen") {
                        ProductListScreen(navController = navController)
                    }
                    composable(
                        "product_detail_screen/{productName}",
                        arguments = listOf(
                            navArgument("productName") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val productName = remember {
                            it.arguments?.getString("productName")
                        }
                        ProductDetailScreen(
                            productName = productName ?: "",
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}