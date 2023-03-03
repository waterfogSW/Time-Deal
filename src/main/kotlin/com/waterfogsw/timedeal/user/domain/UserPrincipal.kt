package com.waterfogsw.timedeal.user.domain

import java.io.Serializable
import java.util.UUID

data class UserPrincipal(
    val id: UUID,
    val username: String,
    val role: User.Role,
) : Serializable {

    companion object {
        const val SESSION_NAME = "USER_SESSION"
        fun from(user: User): UserPrincipal {
            requireNotNull(user.id) { "To make session, user id must not be null" }
            return UserPrincipal(
                id = user.id,
                username = user.username,
                role = user.role,
            )
        }
    }
}
