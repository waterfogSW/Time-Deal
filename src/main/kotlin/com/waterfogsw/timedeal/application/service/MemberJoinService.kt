package com.waterfogsw.timedeal.application.service

import com.waterfogsw.timedeal.adapter.`in`.web.dto.MemberJoinRequest
import com.waterfogsw.timedeal.application.port.`in`.MemberJoinCommand
import com.waterfogsw.timedeal.application.port.out.MemberCreatePort
import com.waterfogsw.timedeal.domain.Member
import org.springframework.stereotype.Service

@Service
class MemberJoinService(
  private val memberCreatePort: MemberCreatePort,
) : MemberJoinCommand {

  override fun join(memberJoinRequest: MemberJoinRequest) {
    val member = Member(
      username = memberJoinRequest.username,
      password = memberJoinRequest.password
    )

    memberCreatePort.create(member)
  }

}
