package com.waterfogsw.timedeal.product.application.service

import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductUpdateRequest
import com.waterfogsw.timedeal.product.application.port.`in`.ProductLookupPort
import com.waterfogsw.timedeal.product.application.port.`in`.ProductUpdateCommand
import com.waterfogsw.timedeal.product.application.port.out.ProductSavePort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class ProductUpdateService(
    private val productLookupPort: ProductLookupPort,
    private val productSavePort: ProductSavePort,
) : ProductUpdateCommand {

    @Transactional
    override fun update(
        id: Long,
        productUpdateRequest: ProductUpdateRequest,
    ) {
        val product = productLookupPort.findById(id)
        val updatedProduct = product.update(
            name = productUpdateRequest.name,
            description = productUpdateRequest.description,
            imageUrl = productUpdateRequest.imageUrl,
            quantity = productUpdateRequest.quantity,
            originalPrice = productUpdateRequest.originalPrice,
            sellingPrice = productUpdateRequest.sellingPrice,
        )

        productSavePort.save(updatedProduct)
    }
}
