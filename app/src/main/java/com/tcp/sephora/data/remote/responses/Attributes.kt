package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("application")
    val application: Any?,
    @SerializedName("available-on-findation")
    val availableOnFindation: Boolean,
    @SerializedName("available-on-modiface")
    val availableOnModiface: Boolean,
    @SerializedName("benefits")
    val benefits: String,
    @SerializedName("brand-name")
    val brandName: String,
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
    @SerializedName("featured-variant-id")
    val featuredVariantId: Int,
    @SerializedName("findation-id")
    val findationId: Any?,
    @SerializedName("heading")
    val heading: Any?,
    @SerializedName("how-to")
    val howTo: Any?,
    @SerializedName("how-to-text")
    val howToText: String,
    @SerializedName("icon-image-urls")
    val iconImageUrls: List<String>,
    @SerializedName("image-urls")
    val imageUrls: List<String>,
    @SerializedName("image-urls-without-fallbacks")
    val imageUrlsWithoutFallbacks: List<String>,
    @SerializedName("ingredients")
    val ingredients: String,
    @SerializedName("labels")
    val labels: List<Any>,
    @SerializedName("name")
    val name: String,
    @SerializedName("new-arrival")
    val newArrival: Boolean,
    @SerializedName("option-type-categories")
    val optionTypeCategories: List<String>,
    @SerializedName("original-price")
    val originalPrice: Int,
    @SerializedName("pictures-count")
    val picturesCount: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("reviews-count")
    val reviewsCount: Int,
    @SerializedName("sale-text")
    val saleText: String,
    @SerializedName("seo")
    val seo: Seo,
    @SerializedName("slug-url")
    val slugUrl: String,
    @SerializedName("sold-out")
    val soldOut: Boolean,
    @SerializedName("state")
    val state: String,
    @SerializedName("translated-names")
    val translatedNames: TranslatedNames,
    @SerializedName("under-sale")
    val underSale: Boolean,
    @SerializedName("variants-count")
    val variantsCount: Int,
    @SerializedName("waitlisted")
    val waitlisted: Boolean,
    @SerializedName("web-url")
    val webUrl: String,
    @SerializedName("wishlisted")
    val wishlisted: Boolean,
    @SerializedName("zoom-image-urls")
    val zoomImageUrls: List<String>
)