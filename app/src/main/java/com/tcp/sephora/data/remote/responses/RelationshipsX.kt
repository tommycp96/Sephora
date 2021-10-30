package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class RelationshipsX(
    @SerializedName("brand")
    val brand: BrandX,
    @SerializedName("categories")
    val categories: CategoriesX,
    @SerializedName("featured-ad")
    val featuredAd: FeaturedAdX,
    @SerializedName("featured-variant")
    val featuredVariant: FeaturedVariantX,
    @SerializedName("filter-types")
    val filterTypes: FilterTypesX,
    @SerializedName("option-types")
    val optionTypes: OptionTypesX,
    @SerializedName("product-articles")
    val productArticles: ProductArticlesX,
    @SerializedName("variants")
    val variants: VariantsX
)