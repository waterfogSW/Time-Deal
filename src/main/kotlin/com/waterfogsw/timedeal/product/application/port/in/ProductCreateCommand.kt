package com.waterfogsw.timedeal.product.application.port.`in`

import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductCreateRequest

interface ProductCreateCommand {

    fun create(productCreateRequest: ProductCreateRequest)
}
