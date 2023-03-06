package com.waterfogsw.timedeal.product.adapter.out.jpa

import com.querydsl.jpa.impl.JPAQueryFactory
import com.waterfogsw.timedeal.product.adapter.out.jpa.QProductJpaEntity.productJpaEntity
import org.springframework.stereotype.Repository

@Repository
class ProductQueryDSLRepository(
    private val jpaQueryFactory: JPAQueryFactory,
) {

    fun findBySlice(
        id: Long?,
        size: Long,
    ): List<ProductJpaEntity> {
        return jpaQueryFactory
            .selectFrom(productJpaEntity)
            .where(ltProductId(id))
            .orderBy(productJpaEntity.id.desc())
            .limit(size)
            .fetch()
    }

    fun ltProductId(id: Long?) = if (id == null) null else productJpaEntity.id.lt(id)
}
