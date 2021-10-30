package com.tcp.sephora.productlist

import androidx.lifecycle.ViewModel
import com.tcp.sephora.repository.SephoraRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val repository: SephoraRepository
) : ViewModel() {
    private var curPage = 0

    init {
        loadProductPaginated()
    }

    fun loadProductPaginated() {

    }
}