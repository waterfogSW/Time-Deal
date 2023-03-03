package com.waterfogsw.timedeal.product.application.service

import com.waterfogsw.timedeal.product.application.port.`in`.ProductDeleteCommand
import com.waterfogsw.timedeal.product.application.port.out.ProductDeletePort
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ProductDeleteService(
    private val productDeletePort: ProductDeletePort,
) : ProductDeleteCommand {

    override fun delete(id: UUID) {
        productDeletePort.delete(id)
    }
}
