package com.waterfogsw.timedeal.order.adapter.out.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface OrderJpaRepository : JpaRepository<OrderJpaEntity, Long> {

    fun existsByProductIdAndUserId(
        productId: Long,
        userId: Long,
    ): Boolean
}
