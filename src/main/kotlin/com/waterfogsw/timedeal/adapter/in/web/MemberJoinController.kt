package com.waterfogsw.timedeal.adapter.`in`.web

import com.waterfogsw.timedeal.adapter.`in`.web.dto.MemberJoinRequest
import com.waterfogsw.timedeal.application.port.MemberJoinCommand
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/members")
class MemberJoinController(
  private val memberJoinCommand: MemberJoinCommand
) {

  @PostMapping
  fun join(@RequestBody memberJoinRequest: MemberJoinRequest) {
    memberJoinCommand.join(memberJoinRequest)
  }

}
