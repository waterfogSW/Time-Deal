package com.waterfogsw.timedeal.adapter.`in`.web

import com.ninjasquad.springmockk.MockkBean
import com.waterfogsw.timedeal.application.port.`in`.MemberDeleteCommand
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
@WebMvcTest(MemberDeleteController::class)
class MemberDeleteControllerTest(
    @Autowired private val context: WebApplicationContext,
    @MockkBean private val memberDeleteCommand: MemberDeleteCommand,
) : DescribeSpec({

    val restDocumentation = ManualRestDocumentation()
    val mockMvc = restDocMockMvcBuild(context, restDocumentation)

    beforeEach { restDocumentation.beforeTest(javaClass, it.name.testName) }
    afterEach { restDocumentation.afterTest() }

    describe("DELETE /api/members/{id}") {
        val memberId = "0x000"

        every { memberDeleteCommand.delete(memberId) } just runs

        it("해당 회원을 삭제한다") {
            mockMvc
                .perform(delete("/api/members/{id}", memberId))
                .andExpect(status().isOk)
                .andDo(
                    document(
                        "delete-member",
                        pathParameters(
                            parameterWithName("id").description("The id of the member to delete"),
                        ),
                    ),
                )

            verify { memberDeleteCommand.delete(memberId) }
        }
    }
})
