package com.waterfogsw.timedeal.adapter.out.jpa

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface MemberJpaRepository: JpaRepository<MemberJpaEntity, UUID> {
}
