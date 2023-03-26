package com.digital.pocapp.database.tables

import java.math.BigDecimal
import java.math.BigInteger
import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity
@Table(schema = "DIGITAL", name = "PARTS")
data class Parts(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: BigInteger,
    @Column(name = "punctuated_part_number")
    var punctuatedPartNumber: String,
    @Column(name = "part_description")
    var partDescription: String,
    @Column(name = "brand_name")
    var brandName: String,
    @Column(name = "original_retail_price")
    var originalRetailPrice: BigDecimal,
    @Column(name = "image_source")
    val imageUrl: String,
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    val productId: Product,
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_time_stamp", insertable = false, updatable = false)
    val creationTimeStamp: Date? = null
)
