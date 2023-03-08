package com.waterfogsw.timedeal.order.port.service

import com.waterfogsw.timedeal.order.domain.Order
import com.waterfogsw.timedeal.order.port.`in`.OrderCreateCommand
import com.waterfogsw.timedeal.order.port.out.OrderLookupPort
import com.waterfogsw.timedeal.order.port.out.OrderSavePort
import com.waterfogsw.timedeal.product.application.port.`in`.ProductLookupPort
import com.waterfogsw.timedeal.product.application.port.out.ProductSavePort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class OrderCreateService(
    private val productLookupPort: ProductLookupPort,
    private val productSavePort: ProductSavePort,
    private val orderSavePort: OrderSavePort,
    private val orderLookupPort: OrderLookupPort,
) : OrderCreateCommand {

    @Transactional
    override fun create(
        productId: Long,
        userId: Long,
    ) {
        if (orderLookupPort.existsByProductIdAndUserId(productId, userId)) {
            throw IllegalArgumentException("Order already exits")
        }

        val product = productLookupPort.findById(productId)
        product.decrease()
        productSavePort.save(product)

        val order = Order(productId = productId, userId = userId)
        orderSavePort.save(order)
    }
}
