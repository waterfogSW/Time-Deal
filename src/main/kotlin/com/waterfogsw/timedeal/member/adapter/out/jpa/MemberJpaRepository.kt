package com.waterfogsw.timedeal.member.adapter.out.jpa

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MemberJpaRepository : JpaRepository<MemberJpaEntity, UUID> {

    fun findByUsername(username: String): MemberJpaEntity?
}
