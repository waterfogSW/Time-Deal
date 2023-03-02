package com.waterfogsw.timedeal.user.domain

import com.waterfogsw.timedeal.common.exception.LoginFailedException

data class User(
    val id: String? = null,
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
