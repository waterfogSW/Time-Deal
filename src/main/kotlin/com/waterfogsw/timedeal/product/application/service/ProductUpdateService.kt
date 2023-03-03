package com.waterfogsw.timedeal.product.application.service

import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductUpdateRequest
import com.waterfogsw.timedeal.product.application.port.`in`.ProductUpdateCommand
import org.springframework.stereotype.Service

@Service
class ProductUpdateService : ProductUpdateCommand {

    override fun update(
        id: String,
        productUpdateRequest: ProductUpdateRequest,
    ) {
        TODO("Not yet implemented")
    }
}
