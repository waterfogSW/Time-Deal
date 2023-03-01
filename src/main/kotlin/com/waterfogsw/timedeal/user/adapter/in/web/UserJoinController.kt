package com.waterfogsw.timedeal.user.adapter.`in`.web

import com.waterfogsw.timedeal.user.adapter.`in`.web.dto.UserJoinRequest
import com.waterfogsw.timedeal.user.application.port.`in`.UserJoinCommand
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/users")
class UserJoinController(
    private val userJoinCommand: UserJoinCommand,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun join(@RequestBody userJoinRequest: UserJoinRequest) {
        userJoinCommand.join(userJoinRequest)
    }
}
