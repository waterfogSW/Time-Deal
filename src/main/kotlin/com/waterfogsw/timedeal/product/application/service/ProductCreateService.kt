package com.waterfogsw.timedeal.product.application.service

import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductCreateRequest
import com.waterfogsw.timedeal.product.application.port.`in`.ProductCreateCommand
import com.waterfogsw.timedeal.product.application.port.out.ProductSavePort
import com.waterfogsw.timedeal.product.application.service.mapper.ProductDTOMapper
import org.springframework.stereotype.Service

@Service
class ProductCreateService(
    private val productDTOMapper: ProductDTOMapper,
    private val productSavePort: ProductSavePort,
) : ProductCreateCommand {

    override fun create(productCreateRequest: ProductCreateRequest) {
        val product = productDTOMapper.mapToDomain(productCreateRequest)
        productSavePort.save(product)
    }
}
