package com.waterfogsw.timedeal.user.application.port.`in`

import com.waterfogsw.timedeal.user.adapter.`in`.web.dto.UserLoginRequest
import com.waterfogsw.timedeal.user.domain.UserSession

interface UserLoginCommand {

    fun login(userLoginRequest: UserLoginRequest): UserSession
}
