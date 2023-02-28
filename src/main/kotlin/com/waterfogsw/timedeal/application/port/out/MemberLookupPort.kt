package com.waterfogsw.timedeal.application.port.out

import com.waterfogsw.timedeal.domain.Member

interface MemberLookupPort {

    fun findByUsername(username: String): Member
}
