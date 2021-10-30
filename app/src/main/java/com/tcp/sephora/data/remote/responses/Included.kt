package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class Included(
    @SerializedName("attributes")
    val attributes: AttributesXX,
    @SerializedName("id")
    val id: String,
    @SerializedName("relationships")
    val relationships: RelationshipsXX,
    @SerializedName("type")
    val type: String
)