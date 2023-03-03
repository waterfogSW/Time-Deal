package com.waterfogsw.timedeal.product.adapter.`in`.web.dto

data class ProductCreateRequest(
    val name: String,
    val description: String,
    val imageUrl: String,
    val quantity: Long,
    val originalPrice: Long,
    val sellingPrice: Long,
)
