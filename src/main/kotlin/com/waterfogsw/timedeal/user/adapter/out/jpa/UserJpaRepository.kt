package com.waterfogsw.timedeal.user.adapter.out.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<UserJpaEntity, Long> {

    fun findByUsername(username: String): UserJpaEntity?
}
