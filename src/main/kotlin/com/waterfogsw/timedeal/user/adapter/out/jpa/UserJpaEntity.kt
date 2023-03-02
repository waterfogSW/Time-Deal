package com.waterfogsw.timedeal.user.adapter.out.jpa

import com.waterfogsw.timedeal.common.entity.DefaultJpaEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity(name = "`user`")
class UserJpaEntity(
    username: String,
    password: String,
) : DefaultJpaEntity() {

    @Column(nullable = false, unique = true)
    var username: String = username
        private set

    @Column(nullable = false)
    var password: String = password
        private set
}
