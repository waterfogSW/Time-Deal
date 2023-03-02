package com.waterfogsw.timedeal.user.adapter.`in`.web

import com.waterfogsw.timedeal.user.adapter.`in`.web.dto.UserLoginRequest
import com.waterfogsw.timedeal.user.application.port.`in`.UserLoginCommand
import com.waterfogsw.timedeal.user.domain.UserSession
import jakarta.servlet.http.HttpSession
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/users/login")
class UserLoginController(
    private val httpSession: HttpSession,
    private val userLoginCommand: UserLoginCommand,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun login(@RequestBody userLoginRequest: UserLoginRequest) {
        val userSession = userLoginCommand.login(userLoginRequest)
        httpSession.setAttribute(UserSession.SESSION_NAME, userSession)
        httpSession.getAttribute(UserSession.SESSION_NAME)
    }
}
