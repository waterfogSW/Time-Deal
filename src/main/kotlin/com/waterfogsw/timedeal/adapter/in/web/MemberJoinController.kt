package com.waterfogsw.timedeal.adapter.`in`.web

import com.waterfogsw.timedeal.adapter.`in`.web.dto.MemberJoinRequest
import com.waterfogsw.timedeal.application.port.`in`.MemberJoinCommand
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
