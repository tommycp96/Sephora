package com.tcp.sephora.data.remote.responses


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("elastic_search")
    val elasticSearch: Boolean
)