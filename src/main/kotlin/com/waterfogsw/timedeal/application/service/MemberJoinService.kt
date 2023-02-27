package com.waterfogsw.timedeal.application.service

import com.waterfogsw.timedeal.adapter.`in`.web.dto.MemberJoinRequest
import com.waterfogsw.timedeal.application.port.`in`.MemberJoinCommand
import org.springframework.stereotype.Service

@Service
class MemberJoinService : MemberJoinCommand {

  override fun join(memberJoinRequest: MemberJoinRequest) {
    TODO("Not yet implemented")
  }

}
