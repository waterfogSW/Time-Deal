package com.waterfogsw.timedeal.member.application.port.out

import java.util.*

interface MemberDeletePort {

    fun delete(id: UUID)
}
