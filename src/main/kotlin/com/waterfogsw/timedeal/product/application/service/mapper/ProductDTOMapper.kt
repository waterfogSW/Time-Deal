package com.waterfogsw.timedeal.product.application.service.mapper

import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.*
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
            dealEndTime = productCreateRequest.dealEndTime,
        )

    fun mapToDetailResponse(product: Product) =
        ProductDetailResponse(
            id = product.id!!,
            name = product.name,
            description = product.description,
            imageUrl = product.imageUrl,
            quantity = product.quantity,
            originalPrice = product.originalPrice,
            sellingPrice = product.sellingPrice,
            createdAt = product.createdAt!!,
            updatedAt = product.updatedAt!!,
            dealEndTime = product.dealEndTime,
        )

    fun mapToListResponse(products: List<Product>) =
        products
            .map { mapToProductInfo(it) }
            .toList()
            .let { ProductListResponse(it) }

    private fun mapToProductInfo(product: Product) =
        ProductListResponse.ProductInfo(
            id = product.id!!,
            name = product.name,
            description = product.description,
            imageUrl = product.imageUrl,
            quantity = product.quantity,
            originalPrice = product.originalPrice,
            sellingPrice = product.sellingPrice,
            dealEndTime = product.dealEndTime,
        )
}
