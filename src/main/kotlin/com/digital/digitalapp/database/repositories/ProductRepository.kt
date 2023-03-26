package com.digital.pocapp.database.repositories

import com.digital.pocapp.database.tables.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
interface ProductRepository : CrudRepository<Product, BigInteger>
