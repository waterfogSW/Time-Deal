package com.waterfogsw.timedeal.member.application.port.out

import com.waterfogsw.timedeal.member.domain.Member

interface MemberCreatePort {

    fun create(member: Member): Member
}
