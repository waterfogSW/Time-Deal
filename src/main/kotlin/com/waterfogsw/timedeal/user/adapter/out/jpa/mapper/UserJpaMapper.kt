package com.waterfogsw.timedeal.user.adapter.out.jpa.mapper

import com.waterfogsw.timedeal.user.adapter.out.jpa.UserJpaEntity
import com.waterfogsw.timedeal.user.domain.User
import org.springframework.stereotype.Component

@Component
class UserJpaMapper {

    fun mapToDomain(userJpaEntity: UserJpaEntity) =
        User(
            id = userJpaEntity.id.toString(),
            username = userJpaEntity.username,
            password = userJpaEntity.password,
        )

    fun mapToJpaEntity(user: User) =
        UserJpaEntity(
            username = user.username,
            password = user.password,
        )
}
