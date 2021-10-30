package com.tcp.sephora.repository

import com.tcp.sephora.data.remote.SephoraApi
import com.tcp.sephora.data.remote.responses.ProductList
import com.tcp.sephora.util.Resource
import javax.inject.Inject

class SephoraRepository @Inject constructor(
    private val api: SephoraApi
) {
    suspend fun getProductList(limit: Int, offset: Int): Resource<ProductList> {
        val response = try {
            api.getProductList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }
}