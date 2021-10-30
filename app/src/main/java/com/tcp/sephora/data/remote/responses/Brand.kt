package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class Brand(
    @SerializedName("data")
    val `data`: Data
)