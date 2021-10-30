package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class Seo(
    @SerializedName("meta-description")
    val metaDescription: Any?,
    @SerializedName("page-title")
    val pageTitle: Any?
)