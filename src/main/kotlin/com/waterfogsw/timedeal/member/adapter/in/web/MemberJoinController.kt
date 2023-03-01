package com.waterfogsw.timedeal.member.adapter.`in`.web

import com.waterfogsw.timedeal.member.adapter.`in`.web.dto.MemberJoinRequest
import com.waterfogsw.timedeal.member.application.port.`in`.MemberJoinCommand
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/members")
class MemberJoinController(
    private val memberJoinCommand: MemberJoinCommand,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun join(@RequestBody memberJoinRequest: MemberJoinRequest) {
        memberJoinCommand.join(memberJoinRequest)
    }
}
