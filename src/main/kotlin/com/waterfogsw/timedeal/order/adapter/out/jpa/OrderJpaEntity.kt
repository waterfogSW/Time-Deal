package com.waterfogsw.timedeal.order.adapter.out.jpa

import com.waterfogsw.timedeal.common.entity.DefaultJpaEntity
import com.waterfogsw.timedeal.product.adapter.out.jpa.ProductJpaEntity
import com.waterfogsw.timedeal.user.adapter.out.jpa.UserJpaEntity
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne

@Entity(name = "`order`")
class OrderJpaEntity(
    id: Long? = null,
    product: ProductJpaEntity,
    user: UserJpaEntity,
) : DefaultJpaEntity(id = id) {

    @ManyToOne
    var product: ProductJpaEntity = product
        private set

    @ManyToOne
    var user: UserJpaEntity = user
        private set
}
