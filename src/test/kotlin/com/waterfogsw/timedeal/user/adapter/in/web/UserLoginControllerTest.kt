package com.waterfogsw.timedeal.user.adapter.`in`.web

import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import com.waterfogsw.timedeal.user.adapter.`in`.web.dto.UserLoginRequest
import com.waterfogsw.timedeal.user.application.port.`in`.UserLoginCommand
import com.waterfogsw.timedeal.user.domain.User
import com.waterfogsw.timedeal.user.domain.UserPrincipal
import com.waterfogsw.timedeal.util.restDocMockMvcBuild
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.every
import io.mockk.verify
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

@DisplayName("WEB - 로그인 API")
@WebMvcTest(UserLoginController::class)
class UserLoginControllerTest(
    @Autowired private val context: WebApplicationContext,
    @Autowired private val objectMapper: ObjectMapper,
    @MockkBean private val userLoginCommand: UserLoginCommand,
) : DescribeSpec({

    val restDocumentation = ManualRestDocumentation()
    val mockMvc = restDocMockMvcBuild(context, restDocumentation)

    beforeEach { restDocumentation.beforeTest(javaClass, it.name.testName) }
    afterEach { restDocumentation.afterTest() }

    describe("POST /api/users/login") {

        val loginRequest = UserLoginRequest(
            username = "johndoe",
            password = "password",
        )

        val userPrincipal = UserPrincipal(
            id = 1L,
            username = "johndoe",
            role = User.Role.USER,
        )

        every { userLoginCommand.login(loginRequest) } returns userPrincipal

        it("사용자 로그인을 처리하고 세션을 생성한다") {
            mockMvc
                .perform(
                    post("/api/users/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)),
                )
                .andExpect(status().isOk)
                .andDo(
                    document(
                        "login-user",
                        requestFields(
                            fieldWithPath("username")
                                .description("The username of the user"),
                            fieldWithPath("password")
                                .description("The password of the user"),
                        ),
                    ),
                )

            verify { userLoginCommand.login(loginRequest) }
        }
    }
})
