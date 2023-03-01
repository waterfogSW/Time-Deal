package com.waterfogsw.timedeal.member.application.service

import com.waterfogsw.timedeal.member.adapter.`in`.web.dto.MemberJoinRequest
import com.waterfogsw.timedeal.member.application.port.`in`.MemberJoinCommand
import com.waterfogsw.timedeal.member.application.port.out.MemberCreatePort
import com.waterfogsw.timedeal.member.domain.Member
import org.springframework.stereotype.Service

@Service
class MemberJoinService(
    private val memberCreatePort: MemberCreatePort,
) : MemberJoinCommand {

    override fun join(memberJoinRequest: MemberJoinRequest) {
        val member = Member(
            username = memberJoinRequest.username,
            password = memberJoinRequest.password,
        )

        memberCreatePort.create(member)
    }
}
