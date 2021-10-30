package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class Relationships(
    @SerializedName("brand")
    val brand: Brand,
    @SerializedName("categories")
    val categories: Categories,
    @SerializedName("featured-ad")
    val featuredAd: FeaturedAd,
    @SerializedName("featured-variant")
    val featuredVariant: FeaturedVariant,
    @SerializedName("filter-types")
    val filterTypes: FilterTypes,
    @SerializedName("option-types")
    val optionTypes: OptionTypes,
    @SerializedName("product-articles")
    val productArticles: ProductArticles,
    @SerializedName("variants")
    val variants: Variants
)