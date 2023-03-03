package com.waterfogsw.timedeal.product.application.service.mapper

import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductCreateRequest
import com.waterfogsw.timedeal.product.domain.Product
import org.springframework.stereotype.Component

@Component
class ProductDTOMapper {

    fun mapToDomain(productCreateRequest: ProductCreateRequest) =
        Product(
            name = productCreateRequest.name,
            description = productCreateRequest.description,
            imageUrl = productCreateRequest.imageUrl,
            quantity = productCreateRequest.quantity,
            originalPrice = productCreateRequest.originalPrice,
            sellingPrice = productCreateRequest.sellingPrice,
        )
}
