package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class TranslatedNames(
    @SerializedName("name-lng-en")
    val nameLngEn: String
)