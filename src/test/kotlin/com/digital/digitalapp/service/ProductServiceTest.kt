package com.digital.digitalapp.service

import com.digital.digitalapp.common.service.PersistenceService
import com.digital.pocapp.database.tables.Parts
import com.digital.pocapp.database.tables.Product
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.math.BigDecimal
import java.math.BigInteger

class ProductServiceTest{

    @Mock
    private lateinit var mockPersistenceService: PersistenceService
    private lateinit var subject: ProductService
    private val productId = BigInteger.ONE
    private var product = Product(
        productId = productId,
        productName = "Lemans",
        parts = listOf(),
        categoryName = "Helmet"
    )
    private var part1 = Parts(
        id = BigInteger.TWO,
        punctuatedPartNumber = "022-738",
        brandName = "AFG",
        productId = product,
        originalRetailPrice = BigDecimal.TEN,
        imageUrl = "http:://jkkkd.png",
        partDescription = "Great Helmet"
    )
    private var part2 = Parts(
        id = BigInteger.TWO,
        punctuatedPartNumber = "022-738",
        brandName = "AFG",
        productId = product,
        originalRetailPrice = BigDecimal.ONE,
        imageUrl = "http:://jkkkd.png",
        partDescription = "Great Helmet"
    )


    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        subject = ProductService(mockPersistenceService)
        whenever(mockPersistenceService.getProducts())
            .thenReturn(
                listOf(
                    product.copy(parts = listOf(part1,part2))
                )
            )
    }

    @Test
    fun `should be successful when data is pulled from database`(){
        val response = subject.getProducts()
        Assert.assertEquals(response[0].productId,productId )
        Assert.assertEquals(response[0].brandName,"AFG" )
        Assert.assertEquals(response[0].minPrice,BigDecimal.ONE)
        Assert.assertEquals(response[0].maxPrice,BigDecimal.TEN)
    }

    @Test(expected = Exception::class)
    fun `should throw error`(){
        whenever(mockPersistenceService.getProducts())
            .thenThrow(Exception::class.java)
         subject.getProducts()
    }
}
