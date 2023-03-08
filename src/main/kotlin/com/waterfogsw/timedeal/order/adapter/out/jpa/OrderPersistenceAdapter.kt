package com.waterfogsw.timedeal.order.adapter.out.jpa

import com.waterfogsw.timedeal.common.annotation.Adapter
import com.waterfogsw.timedeal.common.exception.NotFoundException
import com.waterfogsw.timedeal.order.domain.Order
import com.waterfogsw.timedeal.order.port.out.OrderLookupPort
import com.waterfogsw.timedeal.order.port.out.OrderSavePort
import com.waterfogsw.timedeal.product.adapter.out.jpa.ProductJpaRepository
import com.waterfogsw.timedeal.user.adapter.out.jpa.UserJpaRepository

@Adapter
class OrderPersistenceAdapter(
    private val orderJpaRepository: OrderJpaRepository,
    private val userJpaRepository: UserJpaRepository,
    private val productJpaRepository: ProductJpaRepository,
) : OrderSavePort, OrderLookupPort {

    override fun save(order: Order) {
        val productJpaEntity = productJpaRepository
            .findById(order.productId)
            .orElseThrow { NotFoundException("Product(id = ${order.productId}) not found") }

        val userJpaEntity = userJpaRepository
            .findById(order.userId)
            .orElseThrow { NotFoundException("User(id = ${order.userId}) not found") }

        val orderJpaEntity = OrderJpaEntity(product = productJpaEntity, user = userJpaEntity)
        orderJpaRepository.save(orderJpaEntity)
    }

    override fun existsByProductIdAndUserId(
        productId: Long,
        userId: Long,
    ) = orderJpaRepository.existsByProductIdAndUserId(productId, userId)
}
