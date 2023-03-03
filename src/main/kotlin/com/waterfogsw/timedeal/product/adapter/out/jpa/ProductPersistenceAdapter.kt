package com.waterfogsw.timedeal.product.adapter.out.jpa

import com.waterfogsw.timedeal.common.annotation.Adapter
import com.waterfogsw.timedeal.product.application.port.out.ProductCreatePort
import com.waterfogsw.timedeal.product.domain.Product

@Adapter
class ProductPersistenceAdapter : ProductCreatePort {

    override fun create(product: Product): Product {
        TODO("Not yet implemented")
    }
}
