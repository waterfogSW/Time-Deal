package com.waterfogsw.timedeal.user.application.port.out

import com.waterfogsw.timedeal.user.domain.User

interface UserSavePort {

    fun save(user: User): User
}
