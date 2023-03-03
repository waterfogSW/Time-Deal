package com.waterfogsw.timedeal.product.adapter.`in`.web.dto

data class ProductCreateRequest(
    val name: String,
    val description: String,
    val imageUrl: String? = null,
    val quantity: Long,
    val originalPrice: Long,
    val sellingPrice: Long,
)
