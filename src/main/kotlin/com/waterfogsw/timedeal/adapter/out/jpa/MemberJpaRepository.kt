package com.waterfogsw.timedeal.adapter.out.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface MemberJpaRepository: JpaRepository<MemberJpaEntity, Long> {
}
