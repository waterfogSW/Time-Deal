package com.waterfogsw.timedeal.order.port.service

import com.waterfogsw.timedeal.order.port.`in`.OrderCreateCommand
import org.springframework.stereotype.Service

@Service
class OrderCreateService : OrderCreateCommand {

    override fun create(
        productId: Long,
        userId: Long,
    ) {
        TODO("Not yet implemented")
    }
}
