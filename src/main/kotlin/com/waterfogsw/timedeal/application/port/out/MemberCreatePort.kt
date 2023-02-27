package com.waterfogsw.timedeal.application.port.out

import com.waterfogsw.timedeal.domain.Member

interface MemberCreatePort {

  fun create(member: Member): Member

}
