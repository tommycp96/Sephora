package com.tcp.sephora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                        "product_detail_screen/{productId}",
                        arguments = listOf(
                            navArgument("productId") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val productId = remember {
                            it.arguments?.getString("productId")
                        }
                    }
                }
            }
        }
    }
}