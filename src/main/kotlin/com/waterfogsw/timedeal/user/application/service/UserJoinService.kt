package com.waterfogsw.timedeal.user.application.service

import com.waterfogsw.timedeal.user.adapter.`in`.web.dto.UserJoinRequest
import com.waterfogsw.timedeal.user.application.port.`in`.UserJoinCommand
import com.waterfogsw.timedeal.user.application.port.out.UserCreatePort
import com.waterfogsw.timedeal.user.domain.User
import org.springframework.stereotype.Service

@Service
class UserJoinService(
    private val userCreatePort: UserCreatePort,
) : UserJoinCommand {

    override fun join(userJoinRequest: UserJoinRequest) {
        val user = User(
            username = userJoinRequest.username,
            password = userJoinRequest.password,
        )

        userCreatePort.create(user)
    }
}
