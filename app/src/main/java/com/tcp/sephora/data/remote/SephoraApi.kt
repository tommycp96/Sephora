package com.tcp.sephora.data.remote

import com.tcp.sephora.data.remote.responses.Product
import com.tcp.sephora.data.remote.responses.ProductList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SephoraApi {
    @GET("products")
    suspend fun getProductList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): ProductList

    @GET("products?id={id}")
    suspend fun getProductDetail(
        @Path("id") id: String
    ): Product
}