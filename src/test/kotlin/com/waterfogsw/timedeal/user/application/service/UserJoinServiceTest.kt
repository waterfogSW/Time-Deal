package com.waterfogsw.timedeal.user.application.service

import com.waterfogsw.timedeal.user.adapter.`in`.web.dto.UserJoinRequest
import com.waterfogsw.timedeal.user.application.port.out.UserSavePort
import com.waterfogsw.timedeal.user.domain.User
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@DisplayName("Service - 회원 가입 기능")
@ExtendWith(MockitoExtension::class)
class UserJoinServiceTest : DescribeSpec({

    val userSavePort = mockk<UserSavePort>()
    val userJoinService = UserJoinService(userSavePort)

    describe("join(memberJoinRequest)") {
        context("유효한 요청이 전달되면") {
            val userJoinRequest = UserJoinRequest(username = "johndoe", password = "password")

            it("새로운 회원을 생성한다") {
                val user = User(1L, userJoinRequest.username, userJoinRequest.password)
                every { userSavePort.save(any()) } returns user

                userJoinService.join(userJoinRequest)
                verify { userSavePort.save(any()) }
            }
        }
    }
})
