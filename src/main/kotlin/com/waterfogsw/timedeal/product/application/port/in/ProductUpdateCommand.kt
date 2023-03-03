package com.waterfogsw.timedeal.product.application.port.`in`

import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductUpdateRequest

interface ProductUpdateCommand {

    fun update(id: String, productUpdateRequest: ProductUpdateRequest)
}
