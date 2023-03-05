package com.waterfogsw.timedeal.product.application.service

import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductListRequest
import com.waterfogsw.timedeal.product.application.port.`in`.ProductListCommand
import com.waterfogsw.timedeal.product.application.port.`in`.ProductLookupPort
import com.waterfogsw.timedeal.product.application.service.mapper.ProductDTOMapper
import org.springframework.stereotype.Service

@Service
class ProductListService(
    private val productLookupPort: ProductLookupPort,
    private val productDTOMapper: ProductDTOMapper,
) : ProductListCommand {

    override fun list(productListRequest: ProductListRequest) =
        productLookupPort
            .findBySlice(productListRequest.id, productListRequest.size)
            .let { productDTOMapper.mapToListResponse(it) }
}
