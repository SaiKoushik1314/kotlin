package com.digital.digitalapp.service

import com.digital.digitalapp.common.model.GetProductsResponse
import com.digital.digitalapp.common.model.MaxAndMinRetailPrice
import com.digital.digitalapp.common.service.PersistenceService
import com.digital.pocapp.database.tables.Parts
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ProductService(val persistenceService: PersistenceService) {

    val clazz = ProductService::class.java
    val logger = LoggerFactory.getLogger(clazz)

    fun getProducts(): ArrayList<GetProductsResponse> {
        try {
            logger.info("Calling Persistence Service to get Products.")
            val products = persistenceService.getProducts()
            var response = arrayListOf<GetProductsResponse>()
            products.forEach { p ->
                val maxAndMinRetailPrice = getMaximumAmountAndMinAmount(p.parts)
                val getProductsResponse = GetProductsResponse(
                    productName = p.productName,
                    productId = p.productId,
                    brandName = maxAndMinRetailPrice.brandName,
                    maxPrice = maxAndMinRetailPrice.maxOriginalRetailPrice,
                    minPrice = maxAndMinRetailPrice.minOriginalRetailPrice,
                    imageSource = maxAndMinRetailPrice.imageSource
                )
                response.add(getProductsResponse)
            }
            logger.info("Returning Products response.")
            return response
        } catch (exception: Exception) {
            throw exception
        }
    }

    // If the same product has different brands, It would be better to have separate product id for those and make sure they are different.
    private fun getMaximumAmountAndMinAmount(parts: List<Parts>): MaxAndMinRetailPrice {
        var sortedParts = arrayListOf<Parts>()
        parts.sortedBy { part -> part.originalRetailPrice }.toCollection(sortedParts)
        return MaxAndMinRetailPrice(
            minOriginalRetailPrice = sortedParts[0].originalRetailPrice,
            maxOriginalRetailPrice = sortedParts[parts.size - 1].originalRetailPrice,
            brandName = sortedParts[0].brandName,
            imageSource = sortedParts[0].imageUrl
        )
    }
}
