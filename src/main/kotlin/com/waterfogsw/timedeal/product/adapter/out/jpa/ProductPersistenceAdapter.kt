package com.waterfogsw.timedeal.product.adapter.out.jpa

import com.waterfogsw.timedeal.common.annotation.Adapter
import com.waterfogsw.timedeal.common.exception.NotFoundException
import com.waterfogsw.timedeal.product.adapter.out.jpa.mapper.ProductJpaMapper
import com.waterfogsw.timedeal.product.application.port.`in`.ProductLookupPort
import com.waterfogsw.timedeal.product.application.port.out.ProductDeletePort
import com.waterfogsw.timedeal.product.application.port.out.ProductSavePort
import com.waterfogsw.timedeal.product.domain.Product

@Adapter
class ProductPersistenceAdapter(
    private val productJpaMapper: ProductJpaMapper,
    private val productJpaRepository: ProductJpaRepository,
) : ProductSavePort,
    ProductDeletePort,
    ProductLookupPort {

    override fun save(product: Product): Product {
        val productEntity = productJpaMapper.mapToJpaEntity(product)
        val persistEntity = productJpaRepository.save(productEntity)
        return productJpaMapper.mapToDomain(persistEntity)
    }

    override fun delete(id: Long) {
        productJpaRepository.deleteById(id)
    }

    override fun findById(id: Long): Product {
        return productJpaRepository
            .findById(id)
            .map { productJpaMapper.mapToDomain(it) }
            .orElseThrow { NotFoundException("Product(id = $id) not found") }
    }

    override fun findBySlice(
        id: Long,
        size: Long,
    ): List<Product> {
        return productJpaRepository
            .findBySlice(id, size)
            .map { productJpaMapper.mapToDomain(it) }
    }
}
