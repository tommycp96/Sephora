package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class AttributesXX(
    @SerializedName("available")
    val available: Boolean,
    @SerializedName("available-platforms")
    val availablePlatforms: List<String>,
    @SerializedName("brand-limit")
    val brandLimit: Any?,
    @SerializedName("brand-name")
    val brandName: String,
    @SerializedName("brand-slug-url")
    val brandSlugUrl: String,
    @SerializedName("cart-image-url")
    val cartImageUrl: String,
    @SerializedName("cart-image-urls")
    val cartImageUrls: List<String>,
    @SerializedName("closeup-image-urls")
    val closeupImageUrls: List<String>,
    @SerializedName("default-image-urls")
    val defaultImageUrls: List<String>,
    @SerializedName("description")
    val description: String,
    @SerializedName("display-original-price")
    val displayOriginalPrice: String,
    @SerializedName("display-price")
    val displayPrice: String,
    @SerializedName("featured-image-urls")
    val featuredImageUrls: List<String>,
    @SerializedName("icon-image-urls")
    val iconImageUrls: List<String>,
    @SerializedName("icon-url")
    val iconUrl: String,
    @SerializedName("image-url")
    val imageUrl: String,
    @SerializedName("image-urls")
    val imageUrls: List<String>,
    @SerializedName("image-urls-without-fallbacks")
    val imageUrlsWithoutFallbacks: List<String>,
    @SerializedName("inventory")
    val inventory: Int,
    @SerializedName("labels")
    val labels: List<Any>,
    @SerializedName("mobile-app-banner-image")
    val mobileAppBannerImage: Any?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("new-arrival")
    val newArrival: Boolean,
    @SerializedName("option-type-id")
    val optionTypeId: Int,
    @SerializedName("original-price")
    val originalPrice: Int,
    @SerializedName("pictures-count")
    val picturesCount: Int,
    @SerializedName("position")
    val position: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("product-name")
    val productName: String,
    @SerializedName("reviews-count")
    val reviewsCount: Int,
    @SerializedName("sale-text")
    val saleText: String?,
    @SerializedName("sap-sku")
    val sapSku: String,
    @SerializedName("sephora-id")
    val sephoraId: Any?,
    @SerializedName("size")
    val size: String,
    @SerializedName("slug-url")
    val slugUrl: String,
    @SerializedName("sold-out")
    val soldOut: Boolean,
    @SerializedName("sticker")
    val sticker: Boolean,
    @SerializedName("translated-names")
    val translatedNames: TranslatedNamesXX,
    @SerializedName("under-sale")
    val underSale: Boolean,
    @SerializedName("upc")
    val upc: String,
    @SerializedName("value")
    val value: String,
    @SerializedName("zoom-image-url")
    val zoomImageUrl: String,
    @SerializedName("zoom-image-urls")
    val zoomImageUrls: List<String>
)