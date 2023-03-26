package com.digital.digitalapp.controller

import com.digital.digitalapp.common.ANGULAR_CORS
import com.digital.digitalapp.common.GET_PRODUCTS_FULL_PATH
import com.digital.digitalapp.common.model.GetProductsResponse
import com.digital.digitalapp.service.ProductService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    val productService: ProductService
) {

    @GetMapping(GET_PRODUCTS_FULL_PATH)
    @CrossOrigin(origins = [ANGULAR_CORS])
    fun getProducts(
        @RequestHeader requestHeaders: HttpHeaders
    ): ResponseEntity<List<GetProductsResponse>> {
        return ResponseEntity(
            productService.getProducts(),
            HttpStatus.OK
        )
    }
}
