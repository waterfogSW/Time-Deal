package com.waterfogsw.timedeal.user.application.port.out

import java.util.*

interface UserDeletePort {

    fun delete(id: UUID)
}
