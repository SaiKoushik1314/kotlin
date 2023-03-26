package com.digital.pocapp.database.tables

import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import java.math.BigInteger
import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity
@Table(schema = "DIGITAL", name = "PRODUCT")
data class Product(
    @Id
    @Column(name = "product_id")
    val productId: BigInteger,
    @Column(name = "product_name")
    var productName: String,
    @Column(name = "category_name")
    var categoryName: String,
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_time_stamp", insertable = false, updatable = false)
    val creationTimeStamp: Date? = null,
    @OneToMany(mappedBy = "productId")
    @Fetch(value = FetchMode.SELECT)
    val parts: List<Parts>
)
