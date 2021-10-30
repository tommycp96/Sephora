package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class ProductList(
    @SerializedName("data")
    val `data`: List<DataXXXXXX>,
    @SerializedName("included")
    val included: List<Included>,
    @SerializedName("info")
    val info: Info,
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta
)