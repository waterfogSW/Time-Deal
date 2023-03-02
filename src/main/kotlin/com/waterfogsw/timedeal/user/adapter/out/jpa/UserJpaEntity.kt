package com.waterfogsw.timedeal.user.adapter.out.jpa

import com.waterfogsw.timedeal.common.entity.DefaultJpaEntity
import com.waterfogsw.timedeal.user.domain.User
import jakarta.persistence.*

@Entity(name = "`user`")
class UserJpaEntity(
    username: String,
    password: String,
    role: User.Role,
) : DefaultJpaEntity() {

    @Column(nullable = false, unique = true)
    var username: String = username
        private set

    @Column(nullable = false)
    var password: String = password
        private set

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var role: User.Role = role
        private set
}
