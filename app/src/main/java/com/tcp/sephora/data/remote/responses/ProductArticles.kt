package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class ProductArticles(
    @SerializedName("data")
    val `data`: List<Any>
)