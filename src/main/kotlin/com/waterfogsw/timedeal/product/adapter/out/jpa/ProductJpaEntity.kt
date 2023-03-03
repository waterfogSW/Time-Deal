package com.waterfogsw.timedeal.product.adapter.out.jpa

import com.waterfogsw.timedeal.common.entity.DefaultJpaEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity(name = "product")
class ProductJpaEntity(
    id: Long? = null,
    name: String,
    description: String,
    imageUrl: String,
    quantity: Long,
    originalPrice: Long,
    sellingPrice: Long,
) : DefaultJpaEntity(id) {

    @Column(nullable = false)
    var name: String = name
        private set

    @Column(nullable = false)
    var description: String = description
        private set

    @Column(nullable = false)
    var imageUrl: String = imageUrl
        private set

    @Column(nullable = false)
    var quantity: Long = quantity
        private set

    @Column(nullable = false)
    var originalPrice: Long = originalPrice
        private set

    @Column(nullable = false)
    var sellingPrice: Long = sellingPrice
        private set
}
