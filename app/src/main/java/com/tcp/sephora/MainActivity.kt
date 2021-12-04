package com.tcp.sephora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
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
                        "product_detail_screen/{productName}/{brandName}/{productRating}/{displayOriginalPrice}/{displayDiscountPrice}/{imageUrl}/{description}",
                        arguments = listOf(
                            navArgument("productName") {
                                type = NavType.StringType
                            },
                            navArgument("brandName") {
                                type = NavType.StringType
                            },
                            navArgument("productRating") {
                                type = NavType.StringType
                            },
                            navArgument("displayOriginalPrice") {
                                type = NavType.StringType
                            },
                            navArgument("displayDiscountPrice") {
                                type = NavType.StringType
                            },
                            navArgument("imageUrl") {
                                type = NavType.StringType
                            },
                            navArgument("description") {
                                type = androidx.navigation.NavType.StringType
                            }
                        )
                    ) {
                        val productName = remember {
                            it.arguments?.getString("productName")
                        }
                        val brandName = remember {
                            it.arguments?.getString("brandName")
                        }
                        val productRating = remember {
                            it.arguments?.getString("productRating")
                        }
                        val displayOriginalPrice = remember {
                            it.arguments?.getString("displayOriginalPrice")
                        }
                        val displayDiscountPrice = remember {
                            it.arguments?.getString("displayDiscountPrice")
                        }
                        val imageUrl = remember {
                            it.arguments?.getString("imageUrl")
                        }
                        val description = remember {
                            it.arguments?.getString("description")
                        }
                        ProductDetailScreen(
                            productName = productName ?: "",
                            brandName = brandName ?: "",
                            productRating = productRating ?: "",
                            displayOriginalPrice = displayOriginalPrice ?: "",
                            displayDiscountPrice = displayDiscountPrice ?: "",
                            imageUrl = imageUrl ?: "",
                            description = description ?: "",
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}