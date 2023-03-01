package com.waterfogsw.timedeal.user.application.port.out

import com.waterfogsw.timedeal.user.domain.User

interface UserLookupPort {

    fun findByUsername(username: String): User
}
