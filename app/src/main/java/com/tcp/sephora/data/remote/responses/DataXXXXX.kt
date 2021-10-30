package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class DataXXXXX(
    @SerializedName("id")
    val id: String,
    @SerializedName("type")
    val type: String
)