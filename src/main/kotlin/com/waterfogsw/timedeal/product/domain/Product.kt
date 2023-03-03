package com.waterfogsw.timedeal.product.domain

import java.time.LocalDateTime
import java.util.*

data class Product(
    val id: UUID? = null,
    val name: String,
    val description: String,
    val imageUrl: String,
    val quantity: Long,
    val originalPrice: Long,
    val sellingPrice: Long,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
)
