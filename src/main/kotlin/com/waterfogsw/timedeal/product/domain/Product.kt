package com.waterfogsw.timedeal.product.domain

import java.time.LocalDateTime

data class Product(
    val id: Long? = null,
    val name: String,
    val description: String,
    val imageUrl: String,
    var quantity: Long,
    val originalPrice: Long,
    val sellingPrice: Long,
    val dealEndTime: LocalDateTime,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
) {
    init {
        require(LocalDateTime.now() < dealEndTime) { "The end time of the deal must be later than the current time." }
    }

    fun decrease() {
        require(this.quantity > 0) { "The product is out of stock" }
        this.quantity -= 1
    }

    fun update(
        name: String = this.name,
        description: String = this.description,
        imageUrl: String = this.imageUrl,
        quantity: Long = this.quantity,
        originalPrice: Long = this.originalPrice,
        sellingPrice: Long = this.sellingPrice,
        dealEndTime: LocalDateTime = this.dealEndTime,
    ) = this.copy(
        name = name,
        description = description,
        imageUrl = imageUrl,
        quantity = quantity,
        originalPrice = originalPrice,
        sellingPrice = sellingPrice,
        updatedAt = LocalDateTime.now(),
        dealEndTime = dealEndTime,
    )
}
