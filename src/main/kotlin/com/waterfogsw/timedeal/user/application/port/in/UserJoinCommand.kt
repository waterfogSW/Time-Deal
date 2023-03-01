package com.waterfogsw.timedeal.user.application.port.`in`

import com.waterfogsw.timedeal.user.adapter.`in`.web.dto.UserJoinRequest

interface UserJoinCommand {

    fun join(userJoinRequest: UserJoinRequest)
}
