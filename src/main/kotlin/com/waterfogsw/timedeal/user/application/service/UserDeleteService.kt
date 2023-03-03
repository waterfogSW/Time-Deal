package com.waterfogsw.timedeal.user.application.service

import com.waterfogsw.timedeal.user.application.port.`in`.UserDeleteCommand
import com.waterfogsw.timedeal.user.application.port.out.UserDeletePort
import org.springframework.stereotype.Service

@Service
class UserDeleteService(
    private val userDeletePort: UserDeletePort,
) : UserDeleteCommand {

    override fun delete(id: Long) {
        userDeletePort.delete(id)
    }
}
