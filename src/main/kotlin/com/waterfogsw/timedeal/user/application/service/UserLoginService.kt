package com.waterfogsw.timedeal.user.application.service

import com.waterfogsw.timedeal.user.adapter.`in`.web.dto.UserLoginRequest
import com.waterfogsw.timedeal.user.application.port.`in`.UserLoginCommand
import com.waterfogsw.timedeal.user.domain.User
import com.waterfogsw.timedeal.user.domain.UserSession
import org.springframework.stereotype.Service

@Service
class UserLoginService : UserLoginCommand {

    override fun login(userLoginRequest: UserLoginRequest): UserSession {
        return UserSession("0x00", "test", User.Role.USER)
    }
}
