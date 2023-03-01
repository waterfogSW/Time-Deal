package com.waterfogsw.timedeal.user.adapter.`in`.web

import com.ninjasquad.springmockk.MockkBean
import com.waterfogsw.timedeal.user.application.port.`in`.UserDeleteCommand
import com.waterfogsw.timedeal.util.restDocMockMvcBuild
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.restdocs.ManualRestDocumentation
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete
import org.springframework.restdocs.request.RequestDocumentation.parameterWithName
import org.springframework.restdocs.request.RequestDocumentation.pathParameters
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.web.context.WebApplicationContext

@DisplayName("WEB - 회원 탈퇴 API")
@WebMvcTest(UserDeleteController::class)
class UserDeleteControllerTest(
    @Autowired private val context: WebApplicationContext,
    @MockkBean private val userDeleteCommand: UserDeleteCommand,
) : DescribeSpec({

    val restDocumentation = ManualRestDocumentation()
    val mockMvc = restDocMockMvcBuild(context, restDocumentation)

    beforeEach { restDocumentation.beforeTest(javaClass, it.name.testName) }
    afterEach { restDocumentation.afterTest() }

    describe("DELETE /api/users/{id}") {
        val userId = "0x000"

        every { userDeleteCommand.delete(userId) } just runs

        it("해당 회원을 삭제한다") {
            mockMvc
                .perform(delete("/api/users/{id}", userId))
                .andExpect(status().isOk)
                .andDo(
                    document(
                        "delete-user",
                        pathParameters(
                            parameterWithName("id").description("The id of the user to delete"),
                        ),
                    ),
                )

            verify { userDeleteCommand.delete(userId) }
        }
    }
})
