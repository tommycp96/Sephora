package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class FeaturedVariant(
    @SerializedName("data")
    val `data`: DataXX
)