package com.waterfogsw.timedeal.product.application.service

import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductDetailResponse
import com.waterfogsw.timedeal.product.application.port.`in`.ProductDetailCommand
import com.waterfogsw.timedeal.product.application.port.`in`.ProductLookupPort
import com.waterfogsw.timedeal.product.application.service.mapper.ProductDTOMapper
import org.springframework.stereotype.Service

@Service
class ProductDetailService(
    private val productLookupPort: ProductLookupPort,
    private val productDTOMapper: ProductDTOMapper,
) : ProductDetailCommand {

    override fun detail(id: Long): ProductDetailResponse {
        val product = productLookupPort.findById(id)
        return productDTOMapper.mapToDetailResponse(product)
    }
}
