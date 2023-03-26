package com.digital.pocapp.database.repositories

import com.digital.pocapp.database.tables.Parts
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
interface PartsRepository : CrudRepository<Parts, BigInteger>
