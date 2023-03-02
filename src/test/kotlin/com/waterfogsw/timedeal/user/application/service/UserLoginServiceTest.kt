package com.waterfogsw.timedeal.user.application.service

import com.waterfogsw.timedeal.common.exception.LoginFailedException
import com.waterfogsw.timedeal.user.adapter.`in`.web.dto.UserLoginRequest
import com.waterfogsw.timedeal.user.application.port.out.UserLookupPort
import com.waterfogsw.timedeal.user.domain.User
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

@DisplayName("Service - 로그인 기능")
class UserLoginServiceTest : DescribeSpec({

    val userLookupPort = mockk<UserLookupPort>()
    val userLoginService = UserLoginService(userLookupPort)

    context("유효한 사용자 정보로 로그인 요청을 보낸 경우") {

        val user = User(
            id = "0x000",
            username = "johndoe",
            password = "password",
        )

        val userLoginRequest = UserLoginRequest(
            username = user.username,
            password = user.password,
        )

        it("사용자를 인증하고 로그인 세션을 생성한다") {

            every { userLookupPort.findByUsername(user.username) } returns user

            val result = userLoginService.login(userLoginRequest)

            assertThat(result.id).isEqualTo(user.id)
        }
    }

    context("잘못된 비밀번호로 로그인 요청을 보낸 경우") {

        val user = User(
            id = "0x000",
            username = "johndoe",
            password = "password",
            role = User.Role.USER,
        )

        val userLoginRequest = UserLoginRequest(
            username = user.username,
            password = "wrongpassword",
        )

        it("로그인에 실패하고 LoginFailedException을 발생시킨다") {

            every { userLookupPort.findByUsername(user.username) } returns user

            assertThrows<LoginFailedException> {
                userLoginService.login(userLoginRequest)
            }
        }
    }
})
