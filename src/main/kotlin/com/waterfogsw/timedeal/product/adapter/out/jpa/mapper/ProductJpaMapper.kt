package com.waterfogsw.timedeal.product.adapter.out.jpa.mapper

import com.waterfogsw.timedeal.product.adapter.out.jpa.ProductJpaEntity
import com.waterfogsw.timedeal.product.domain.Product
import org.springframework.stereotype.Component

@Component
class ProductJpaMapper {

    fun mapToJpaEntity(product: Product) =
        ProductJpaEntity(
            id = product.id,
            name = product.name,
            description = product.description,
            imageUrl = product.imageUrl,
            quantity = product.quantity,
            originalPrice = product.originalPrice,
            sellingPrice = product.sellingPrice,
        )

    fun mapToDomain(productJpaEntity: ProductJpaEntity) =
        Product(
            id = productJpaEntity.id,
            name = productJpaEntity.name,
            description = productJpaEntity.description,
            imageUrl = productJpaEntity.imageUrl,
            quantity = productJpaEntity.quantity,
            originalPrice = productJpaEntity.originalPrice,
            sellingPrice = productJpaEntity.sellingPrice,
            createdAt = productJpaEntity.createdAt,
            updatedAt = productJpaEntity.updatedAt,
        )
}
