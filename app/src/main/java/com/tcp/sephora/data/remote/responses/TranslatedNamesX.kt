package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class TranslatedNamesX(
    @SerializedName("name-lng-en")
    val nameLngEn: String,
    @SerializedName("name-vi-vn")
    val nameViVn: String,
    @SerializedName("name-zh-tw")
    val nameZhTw: String
)