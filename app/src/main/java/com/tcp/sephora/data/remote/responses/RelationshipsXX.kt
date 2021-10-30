package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class RelationshipsXX(
    @SerializedName("ads")
    val ads: Ads,
    @SerializedName("filter-values")
    val filterValues: FilterValues,
    @SerializedName("ingredient-preference")
    val ingredientPreference: IngredientPreference,
    @SerializedName("option-type")
    val optionType: OptionType,
    @SerializedName("option-values")
    val optionValues: OptionValues,
    @SerializedName("product")
    val product: ProductX
)