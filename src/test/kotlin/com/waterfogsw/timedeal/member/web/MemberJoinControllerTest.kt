package com.waterfogsw.timedeal.member.web

import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import com.waterfogsw.timedeal.member.adapter.`in`.web.MemberJoinController
import com.waterfogsw.timedeal.member.adapter.`in`.web.dto.MemberJoinRequest
import com.waterfogsw.timedeal.member.application.port.`in`.MemberJoinCommand
import com.waterfogsw.timedeal.util.restDocMockMvcBuild
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.restdocs.ManualRestDocumentation
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.requestFields
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.web.context.WebApplicationContext

@DisplayName("WEB - 회원 가입 API")
@WebMvcTest(MemberJoinController::class)
class MemberJoinControllerTest(
    @Autowired private val context: WebApplicationContext,
    @Autowired private val objectMapper: ObjectMapper,
    @MockkBean private val memberJoinCommand: MemberJoinCommand,
) : DescribeSpec({

    val restDocumentation = ManualRestDocumentation()
    val mockMvc = restDocMockMvcBuild(context, restDocumentation)

    beforeEach { restDocumentation.beforeTest(javaClass, it.name.testName) }
    afterEach { restDocumentation.afterTest() }

    describe("POST /api/members") {

        val joinRequest = MemberJoinRequest(
            username = "johndoe",
            password = "password",
        )

        every { memberJoinCommand.join(joinRequest) } just runs

        it("새로운 회원을 생성한다") {
            mockMvc
                .perform(
                    post("/api/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(joinRequest)),
                )
                .andExpect(status().isCreated)
                .andDo(
                    document(
                        "join-member",
                        requestFields(
                            fieldWithPath("username")
                                .description("The username of the member"),
                            fieldWithPath("password")
                                .description("The password of the member"),
                        ),
                    ),
                )

            verify { memberJoinCommand.join(joinRequest) }
        }
    }
})
