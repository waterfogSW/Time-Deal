package com.waterfogsw.timedeal.user.application.service

import com.github.f4b6a3.ulid.UlidCreator
import com.waterfogsw.timedeal.user.application.port.out.UserDeletePort
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@DisplayName("Service - 회원 탈퇴 기능")
@ExtendWith(MockitoExtension::class)
class UserDeleteServiceTest : DescribeSpec({

    val userDeletePort = mockk<UserDeletePort>()
    val userDeleteService = UserDeleteService(userDeletePort)

    describe("delete(UUID)") {
        context("유효한 요청이 전달되면") {
            val uuid = UlidCreator
                .getMonotonicUlid()
                .toUuid()
                .toString()

            it("해당 id값의 회원을 삭제한다") {
                every { userDeletePort.delete(UUID.fromString(uuid)) } just runs

                userDeleteService.delete(uuid)

                verify { userDeletePort.delete(UUID.fromString(uuid)) }
            }
        }
    }
})
