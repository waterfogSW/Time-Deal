package com.waterfogsw.timedeal.product.adapter.out.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface ProductJpaRepository : JpaRepository<ProductJpaEntity, Long>
