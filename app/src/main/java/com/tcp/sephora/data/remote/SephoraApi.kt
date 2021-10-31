package com.tcp.sephora.data.remote

import com.tcp.sephora.data.remote.responses.Product
import com.tcp.sephora.data.remote.responses.ProductList
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface SephoraApi {
    @Headers(
        "X-OS-Name: android",
        "X-App-Platform: mobileapp_android",
        "X-Platform: mobile_app",
        "X-Site-Country: SG",
        "Accept-Language: en-SG"
    )
    @GET("products?")
    suspend fun getProductList(
        @Query("page[number]") limit: String,
        @Query("include") include1: String,
        @Query("filter[landing_page]") filter: String,
        @Query("include") include2: String,
        @Query("sort") sort: String,
    ): ProductList

    @GET("products?id={id}")
    suspend fun getProductDetail(
        @Path("id") id: String
    ): Product
}