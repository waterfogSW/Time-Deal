package com.waterfogsw.timedeal.order.port.out

interface OrderLookupPort {

    fun existsByProductIdAndUserId(
        productId: Long,
        userId: Long,
    ): Boolean
}
