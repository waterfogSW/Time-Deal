package com.waterfogsw.timedeal.product.application.service

import com.waterfogsw.timedeal.product.application.port.`in`.ProductDeleteCommand
import org.springframework.stereotype.Service

@Service
class ProductDeleteService : ProductDeleteCommand {

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }
}
