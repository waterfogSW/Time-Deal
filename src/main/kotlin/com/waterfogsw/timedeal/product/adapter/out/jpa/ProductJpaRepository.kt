package com.waterfogsw.timedeal.product.adapter.out.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ProductJpaRepository : JpaRepository<ProductJpaEntity, Long> {

    @Query("select p from product p where p.id < :id order by p.id desc limit :size")
    fun findBySlice(
        id: Long?,
        size: Long,
    ): List<ProductJpaEntity>
}
