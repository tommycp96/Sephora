package com.tcp.sephora.repository

import com.tcp.sephora.data.remote.SephoraApi
import com.tcp.sephora.data.remote.responses.ProductList
import com.tcp.sephora.util.Resource
import timber.log.Timber
import javax.inject.Inject

class SephoraRepository @Inject constructor(
    private val api: SephoraApi
) {
    suspend fun getProductList(limit: String, include1: String, filter: String, include2: String, sort: String): Resource<ProductList> {
        val response = try {
            api.getProductList(limit, include1, filter, include2, sort)
        } catch (e: Exception) {
            Timber.tag("Error").e(e.toString())
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }
}