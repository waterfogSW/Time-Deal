package com.waterfogsw.timedeal.user.adapter.`in`.web

import jakarta.servlet.http.HttpSession
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/users/logout")
class UserLogoutController(
    private val httpSession: HttpSession,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun logout() {
        httpSession.invalidate()
    }
}
