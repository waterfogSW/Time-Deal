package com.waterfogsw.timedeal.user.application.port.`in`

import java.util.*

interface UserDeleteCommand {

    fun delete(id: UUID)
}
