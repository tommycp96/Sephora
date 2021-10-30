package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class DataXXXXXX(
    @SerializedName("attributes")
    val attributes: AttributesX,
    @SerializedName("id")
    val id: String,
    @SerializedName("relationships")
    val relationships: RelationshipsX,
    @SerializedName("type")
    val type: String
)