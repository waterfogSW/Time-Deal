package com.waterfogsw.timedeal.user.adapter.out.jpa

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserJpaRepository : JpaRepository<UserJpaEntity, UUID> {

    fun findByUsername(username: String): UserJpaEntity?
}
