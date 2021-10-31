package com.tcp.sephora.productdetail

import androidx.lifecycle.ViewModel
import com.tcp.sephora.data.remote.responses.Product
import com.tcp.sephora.repository.SephoraRepository
import com.tcp.sephora.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val repository: SephoraRepository
) : ViewModel() {

}