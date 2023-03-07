package com.waterfogsw.timedeal.order.port.`in`

interface OrderCreateCommand {

    fun create(
        productId: Long,
        userId: Long,
    )
}
