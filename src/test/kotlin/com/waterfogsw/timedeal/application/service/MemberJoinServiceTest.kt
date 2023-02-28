package com.waterfogsw.timedeal.application.service

import com.waterfogsw.timedeal.adapter.`in`.web.dto.MemberJoinRequest
import com.waterfogsw.timedeal.application.port.out.MemberCreatePort
import com.waterfogsw.timedeal.domain.Member
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@DisplayName("Service - 회원 가입 기능")
@ExtendWith(MockitoExtension::class)
class MemberJoinServiceTest : DescribeSpec({

    val memberCreatePort = mockk<MemberCreatePort>()
    val memberJoinService = MemberJoinService(memberCreatePort)

    describe("join(memberJoinRequest)") {
        context("유효한 요청이 전달되면") {
            val memberJoinRequest = MemberJoinRequest(username = "johndoe", password = "password")

            it("새로운 회원을 생성한다") {
                val member = Member("0x000", memberJoinRequest.username, memberJoinRequest.password)
                every { memberCreatePort.create(any()) } returns member

                memberJoinService.join(memberJoinRequest)
                verify { memberCreatePort.create(any()) }
            }
        }
    }
})
