package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("current-page")
    val currentPage: Int,
    @SerializedName("landing-page-name")
    val landingPageName: String,
    @SerializedName("per-page")
    val perPage: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total-items")
    val totalItems: Int,
    @SerializedName("total-pages")
    val totalPages: Int
)