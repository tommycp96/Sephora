package com.tcp.sephora.data.models

data class ProductListEntry(
    val productId: String,
    val productName: String,
    val brandName: String,
    val originalPrice: Int,
    val productRating: Double,
    val variantsCount: Int,
    val reviewsCount: Int,
    val imageUrl: String,
    val discountPrice: Int,
    val displayOriginalPrice: String,
    val displayDiscountPrice: String,
    val description: String
)
