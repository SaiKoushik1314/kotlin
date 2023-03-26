package com.digital.digitalapp.common.model

import java.math.BigDecimal

data class MaxAndMinRetailPrice (
    val minOriginalRetailPrice: BigDecimal,
    val maxOriginalRetailPrice: BigDecimal,
    val brandName: String,
    val imageSource: String
)
