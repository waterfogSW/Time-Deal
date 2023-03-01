package com.waterfogsw.timedeal.member.application.port.`in`

import com.waterfogsw.timedeal.member.adapter.`in`.web.dto.MemberJoinRequest

interface MemberJoinCommand {

    fun join(memberJoinRequest: MemberJoinRequest)
}
