package com.waterfogsw.timedeal.product.application.port.`in`

import com.waterfogsw.timedeal.product.domain.Product

interface ProductLookupPort {

    fun findById(id: Long): Product

    fun findBySlice(
        id: Long?,
        size: Long,
    ): List<Product>
}
