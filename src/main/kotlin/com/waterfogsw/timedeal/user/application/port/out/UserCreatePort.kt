package com.waterfogsw.timedeal.user.application.port.out

import com.waterfogsw.timedeal.user.domain.User

interface UserCreatePort {

    fun create(user: User): User
}
