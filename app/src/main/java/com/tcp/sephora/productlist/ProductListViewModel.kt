package com.tcp.sephora.productlist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tcp.sephora.data.models.ProductListEntry
import com.tcp.sephora.repository.SephoraRepository
import com.tcp.sephora.util.Constants.FILTER
import com.tcp.sephora.util.Constants.INCLUDE1
import com.tcp.sephora.util.Constants.INCLUDE2
import com.tcp.sephora.util.Constants.LIMIT
import com.tcp.sephora.util.Constants.PAGE_SIZE
import com.tcp.sephora.util.Constants.SORT
import com.tcp.sephora.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val repository: SephoraRepository
) : ViewModel() {
    private var curPage = 0

    var productList = mutableStateOf<List<ProductListEntry>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)

    private var cachedProductList = listOf<ProductListEntry>()
    private var isSearchStarting = true
    var isSearching = mutableStateOf(false)

    init {
        loadProductPaginated()
    }

    fun searchPokemonList(query: String) {
        val listToSearch = if(isSearchStarting) {
            productList.value
        } else {
            cachedProductList
        }
        viewModelScope.launch(Dispatchers.Default) {
            if(query.isEmpty()) {
                productList.value = cachedProductList
                isSearching.value = false
                isSearchStarting = true
                return@launch
            }
            val results = listToSearch.filter {
                it.productName.contains(query.trim(), ignoreCase = true) ||
                        it.brandName.contains(query.trim(), ignoreCase = true)
            }
            if(isSearchStarting) {
                cachedProductList = productList.value
                isSearchStarting = false
            }
            productList.value = results
            isSearching.value = true
        }
    }

    fun loadProductPaginated() {
        viewModelScope.launch {
            isLoading.value = true
            val result = repository.getProductList(LIMIT, INCLUDE1, FILTER, INCLUDE2, SORT)
            when(result) {
                is Resource.Success -> {
                    endReached.value = curPage * PAGE_SIZE >= result.data?.data!!.count()
                    val productEntries = result.data.data.mapIndexed { index, entry ->
                        ProductListEntry(
                            entry.id,
                            entry.attributes.name.replaceFirstChar {
                                if (it.isLowerCase()) it.titlecase(
                                    Locale.ROOT
                                ) else it.toString()
                            },
                            entry.attributes.brandName,
                            entry.attributes.originalPrice,
                            entry.attributes.rating,
                            entry.attributes.variantsCount,
                            entry.attributes.reviewsCount,
                            entry.attributes.defaultImageUrls.first(),
                            entry.attributes.price,
                            entry.attributes.displayOriginalPrice,
                            entry.attributes.displayPrice,
                            entry.attributes.description
                        )
                    }
                    curPage++

                    loadError.value = ""
                    isLoading.value = false
                    productList.value += productEntries
                }
                is Resource.Error -> {
                    loadError.value = result.message!!
                    isLoading.value = false
                }
            }
        }
    }
}