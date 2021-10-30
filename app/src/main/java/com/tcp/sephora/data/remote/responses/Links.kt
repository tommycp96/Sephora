package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("last")
    val last: String,
    @SerializedName("next")
    val next: String,
    @SerializedName("self")
    val self: String
)