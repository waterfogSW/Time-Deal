package com.waterfogsw.timedeal.product.adapter.out.jpa

import com.waterfogsw.timedeal.common.annotation.Adapter
import com.waterfogsw.timedeal.product.adapter.out.jpa.mapper.ProductJpaMapper
import com.waterfogsw.timedeal.product.application.port.out.ProductCreatePort
import com.waterfogsw.timedeal.product.domain.Product

@Adapter
class ProductPersistenceAdapter(
    private val productJpaMapper: ProductJpaMapper,
    private val productJpaRepository: ProductJpaRepository,
) : ProductCreatePort {

    override fun create(product: Product): Product {
        val productEntity = productJpaMapper.mapToJpaEntity(product)
        val persistEntity = productJpaRepository.save(productEntity)
        return productJpaMapper.mapToDomain(persistEntity)
    }
}
