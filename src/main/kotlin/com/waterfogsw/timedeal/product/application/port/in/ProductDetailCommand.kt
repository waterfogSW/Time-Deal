package com.waterfogsw.timedeal.product.application.port.`in`

import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductDetailResponse

interface ProductDetailCommand {

    fun detail(id: Long): ProductDetailResponse
}
