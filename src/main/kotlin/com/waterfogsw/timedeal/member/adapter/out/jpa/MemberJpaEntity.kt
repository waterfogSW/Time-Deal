package com.waterfogsw.timedeal.member.adapter.out.jpa

import com.waterfogsw.timedeal.common.entity.DefaultJpaEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity(name = "member")
class MemberJpaEntity(
    username: String,
    password: String,
) : DefaultJpaEntity() {

    @Column(nullable = false)
    var username: String = username
        private set

    @Column(nullable = false)
    var password: String = password
        private set
}
