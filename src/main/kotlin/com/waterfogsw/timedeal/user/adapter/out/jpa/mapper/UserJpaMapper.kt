package com.waterfogsw.timedeal.user.adapter.out.jpa.mapper

import com.waterfogsw.timedeal.user.adapter.out.jpa.UserJpaEntity
import com.waterfogsw.timedeal.user.domain.User
import org.springframework.stereotype.Component

@Component
class UserJpaMapper {

    fun mapToDomain(userJpaEntity: UserJpaEntity) =
        User(
            id = userJpaEntity.id,
            username = userJpaEntity.username,
            password = userJpaEntity.password,
            role = userJpaEntity.role,
        )

    fun mapToJpaEntity(user: User) =
        UserJpaEntity(
            id = user.id,
            username = user.username,
            password = user.password,
            role = user.role,
        )
}
