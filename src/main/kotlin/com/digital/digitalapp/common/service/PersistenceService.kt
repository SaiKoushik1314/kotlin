package com.digital.digitalapp.common.service

import com.digital.pocapp.database.repositories.PartsRepository
import com.digital.pocapp.database.repositories.ProductRepository
import com.digital.pocapp.database.tables.Parts
import com.digital.pocapp.database.tables.Product
import org.springframework.stereotype.Service

@Service
class PersistenceService(
    private val partsRepository: PartsRepository,
    private val productRepository: ProductRepository
) {

    fun getParts(): Iterable<Parts> {
        return partsRepository.findAll()
    }

    fun getProducts(): Iterable<Product> = productRepository.findAll()
}
