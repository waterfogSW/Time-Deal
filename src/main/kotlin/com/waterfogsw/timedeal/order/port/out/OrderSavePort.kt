package com.waterfogsw.timedeal.order.port.out

import com.waterfogsw.timedeal.order.domain.Order

interface OrderSavePort {

    fun save(order: Order)
}
