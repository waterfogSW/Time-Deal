package com.waterfogsw.timedeal.product.domain

import java.time.LocalDateTime

data class Product(
    val id: Long? = null,
    val name: String,
    val description: String,
    val imageUrl: String,
    val quantity: Long,
    val originalPrice: Long,
    val sellingPrice: Long,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
) {

    fun update(
        name: String = this.name,
        description: String = this.description,
        imageUrl: String = this.imageUrl,
        quantity: Long = this.quantity,
        originalPrice: Long = this.originalPrice,
        sellingPrice: Long = this.sellingPrice,
    ) = this.copy(
        name = name,
        description = description,
        imageUrl = imageUrl,
        quantity = quantity,
        originalPrice = originalPrice,
        sellingPrice = sellingPrice,
        updatedAt = LocalDateTime.now(),
    )
}
