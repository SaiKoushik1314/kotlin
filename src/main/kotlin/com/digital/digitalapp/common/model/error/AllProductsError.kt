package com.digital.digitalapp.common.model.error

import org.springframework.http.HttpStatus

sealed class AllProductsError {
    data class ProductError(
        val errorResponse: ErrorResponse,
        val httpStatus: HttpStatus
    ) : AllProductsError()
}
