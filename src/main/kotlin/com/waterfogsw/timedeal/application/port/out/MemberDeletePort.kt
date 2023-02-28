package com.waterfogsw.timedeal.application.port.out

import java.util.*

interface MemberDeletePort {

    fun delete(id: UUID)
}
