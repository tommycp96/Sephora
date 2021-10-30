package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class FilterTypes(
    @SerializedName("data")
    val `data`: List<DataXXX>
)