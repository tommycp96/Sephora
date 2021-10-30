package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class Categories(
    @SerializedName("data")
    val `data`: List<DataX>
)