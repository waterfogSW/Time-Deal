package com.waterfogsw.timedeal.member.application.port.out

import com.waterfogsw.timedeal.member.domain.Member

interface MemberLookupPort {

    fun findByUsername(username: String): Member
}
