package com.digital.digitalapp.common.model

import java.math.BigDecimal
import java.math.BigInteger

data class GetProductsResponse(
    val productId: BigInteger,
    val productName: String,
    val brandName: String,
    val minPrice: BigDecimal,
    val maxPrice: BigDecimal,
    val imageSource: String
)
