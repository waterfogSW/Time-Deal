package com.waterfogsw.timedeal.product.application.service

import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductCreateRequest
import com.waterfogsw.timedeal.product.application.port.`in`.ProductCreateCommand
import org.springframework.stereotype.Service

@Service
class ProductCreateService : ProductCreateCommand {

    override fun create(productCreateRequest: ProductCreateRequest) {
        TODO("Not yet implemented")
    }
}
