package com.waterfogsw.timedeal.order.domain

data class Order(
    val id: Long? = null,
    val productId: Long,
    val userId: Long,
)
