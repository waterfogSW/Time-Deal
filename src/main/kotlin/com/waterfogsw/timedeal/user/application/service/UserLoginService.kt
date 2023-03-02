package com.waterfogsw.timedeal.user.application.service

import com.waterfogsw.timedeal.user.adapter.`in`.web.dto.UserLoginRequest
import com.waterfogsw.timedeal.user.application.port.`in`.UserLoginCommand
import com.waterfogsw.timedeal.user.application.port.out.UserLookupPort
import com.waterfogsw.timedeal.user.domain.UserSession
import org.springframework.stereotype.Service

@Service
class UserLoginService(
    private val userLookupPort: UserLookupPort,
) : UserLoginCommand {

    override fun login(userLoginRequest: UserLoginRequest): UserSession {
        val user = userLookupPort.findByUsername(userLoginRequest.username)
        user.checkPassword(userLoginRequest.password)
        return UserSession.from(user)
    }
}
