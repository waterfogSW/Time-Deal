package com.waterfogsw.timedeal.product.adapter.`in`.web.dto

import java.time.LocalDateTime

data class ProductDetailResponse(
    val id: Long,
    val name: String,
    val description: String,
    val imageUrl: String,
    val quantity: Long,
    val originalPrice: Long,
    val sellingPrice: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val dealEndTime: LocalDateTime,
)
