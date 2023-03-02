package com.waterfogsw.timedeal.user.domain

import java.io.Serializable

data class UserSession(
    val id: String,
    val username: String,
    val role: User.Role,
) : Serializable {

    companion object {
        const val SESSION_NAME = "USER_SESSION"
        fun from(user: User): UserSession {
            requireNotNull(user.id) { "To make session, user id must not be null" }
            return UserSession(
                id = user.id,
                username = user.username,
                role = user.role,
            )
        }
    }
}
