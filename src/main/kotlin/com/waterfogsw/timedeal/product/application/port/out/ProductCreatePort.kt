package com.waterfogsw.timedeal.product.application.port.out

import com.waterfogsw.timedeal.product.domain.Product

interface ProductCreatePort {

    fun create(product: Product): Product
}
