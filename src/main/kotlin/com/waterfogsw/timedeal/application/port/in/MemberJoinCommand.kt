package com.waterfogsw.timedeal.application.port.`in`

import com.waterfogsw.timedeal.adapter.`in`.web.dto.MemberJoinRequest

interface MemberJoinCommand {

  fun join(memberJoinRequest: MemberJoinRequest)

}
