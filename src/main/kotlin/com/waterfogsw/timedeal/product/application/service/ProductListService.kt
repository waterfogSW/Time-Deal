package com.waterfogsw.timedeal.product.application.service

import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductListRequest
import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductListResponse
import com.waterfogsw.timedeal.product.application.port.`in`.ProductListCommand
import org.springframework.stereotype.Service

@Service
class ProductListService : ProductListCommand {

    override fun list(productListRequest: ProductListRequest): ProductListResponse {
        TODO("Not yet implemented")
    }
}
