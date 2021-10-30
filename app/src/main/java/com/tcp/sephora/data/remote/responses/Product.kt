package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("id")
    val id: String,
    @SerializedName("relationships")
    val relationships: Relationships,
    @SerializedName("type")
    val type: String
)