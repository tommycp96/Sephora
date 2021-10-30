package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class Ads(
    @SerializedName("data")
    val `data`: List<Any>
)