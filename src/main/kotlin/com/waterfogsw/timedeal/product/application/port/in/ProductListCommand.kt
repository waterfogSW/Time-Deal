package com.waterfogsw.timedeal.product.application.port.`in`

import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductListRequest
import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductListResponse

interface ProductListCommand {

    fun list(productListRequest: ProductListRequest): ProductListResponse
}
