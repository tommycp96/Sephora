package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class FeaturedAd(
    @SerializedName("data")
    val `data`: Any?
)