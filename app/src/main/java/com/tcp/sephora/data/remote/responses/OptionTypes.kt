package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class OptionTypes(
    @SerializedName("data")
    val `data`: List<DataXXXX>
)