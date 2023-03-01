package com.waterfogsw.timedeal.user.adapter.`in`.web

import com.waterfogsw.timedeal.user.application.port.`in`.UserDeleteCommand
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/users")
class UserDeleteController(
    private val userDeleteCommand: UserDeleteCommand,
) {

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable id: String) {
        userDeleteCommand.delete(id)
    }
}
