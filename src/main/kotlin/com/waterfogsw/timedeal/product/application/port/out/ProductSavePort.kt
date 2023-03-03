package com.waterfogsw.timedeal.product.application.port.out

import com.waterfogsw.timedeal.product.domain.Product

interface ProductSavePort {

    fun save(product: Product): Product
}
