package com.waterfogsw.timedeal.user.domain

import com.waterfogsw.timedeal.common.exception.LoginFailedException
import java.util.UUID

data class User(
    val id: UUID? = null,
    val username: String,
    val password: String,
    val role: Role = Role.USER,
) {

    fun checkPassword(inputPassword: String) {
        if (password != inputPassword) {
            throw LoginFailedException("Password incorrect")
        }
    }

    enum class Role {
        ADMIN, USER
    }
}
