package com.tcp.sephora.util

object Constants {
    const val BASE_URL = "https://api.sephora.sg/api/v2.5/"
    const val PAGE_SIZE = 20
    const val LIMIT = "1page[size]=30"
    const val INCLUDE1 = "featured_variant,featured_ad"
    const val FILTER = "sale"
    const val INCLUDE2 = "brand,option_types.option_values,featured_variant,featured_ad"
    const val SORT = "sales"
}