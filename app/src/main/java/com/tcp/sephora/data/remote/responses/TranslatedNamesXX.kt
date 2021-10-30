package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class TranslatedNamesXX(
    @SerializedName("name-ja-jp")
    val nameJaJp: String,
    @SerializedName("name-lng-en")
    val nameLngEn: String,
    @SerializedName("name-vi-vn")
    val nameViVn: String,
    @SerializedName("name-zh-tw")
    val nameZhTw: String
)