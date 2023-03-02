package com.waterfogsw.timedeal.user.domain

data class UserSession(
    val id: String,
    val username: String,
    val role: User.Role,
) {

    companion object {
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
