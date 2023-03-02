package com.waterfogsw.timedeal.user.domain

data class User(
    val id: String? = null,
    val username: String,
    val password: String,
    val role: Role = Role.USER,
) {
    enum class Role {
        ADMIN, USER
    }
}
