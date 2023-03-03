package com.waterfogsw.timedeal.product.adapter.`in`.web

import com.ninjasquad.springmockk.MockkBean
import com.waterfogsw.timedeal.product.application.port.`in`.ProductDeleteCommand
import com.waterfogsw.timedeal.user.domain.User
import com.waterfogsw.timedeal.user.domain.UserPrincipal
import com.waterfogsw.timedeal.util.restDocMockMvcBuild
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.mock.web.MockHttpSession
import org.springframework.restdocs.ManualRestDocumentation
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete
import org.springframework.restdocs.request.RequestDocumentation.parameterWithName
import org.springframework.restdocs.request.RequestDocumentation.pathParameters
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.web.context.WebApplicationContext
import java.util.*

@DisplayName("WEB - 상품 삭제 API")
@WebMvcTest(ProductDeleteController::class)
class ProductDeleteControllerTest(
    @Autowired private val context: WebApplicationContext,
    @MockkBean private val productDeleteCommand: ProductDeleteCommand,
) : DescribeSpec({

    val restDocumentation = ManualRestDocumentation()
    val mockMvc = restDocMockMvcBuild(context, restDocumentation)

    beforeEach { restDocumentation.beforeTest(javaClass, it.name.testName) }
    afterEach { restDocumentation.afterTest() }

    describe("DELETE /api/products/{id}") {

        val productId = 1L

        context("관리자가 요청하면") {

            val user = UserPrincipal(1L, "test", User.Role.ADMIN)
            val mockHttpSession = MockHttpSession()
            mockHttpSession.setAttribute(UserPrincipal.SESSION_NAME, user)

            every { productDeleteCommand.delete(productId) } just runs

            it("상품을 삭제하고 200 응답을 반환한다") {
                mockMvc
                    .perform(
                        delete("/api/products/{id}", productId)
                            .session(mockHttpSession),
                    )
                    .andExpect(status().isOk)
                    .andDo(
                        document(
                            "delete-product",
                            pathParameters(
                                parameterWithName("id").description("The ID of the product"),
                            ),
                        ),
                    )

                verify { productDeleteCommand.delete(productId) }
            }
        }

        context("사용자가 요청하면") {

            val user = UserPrincipal(1L, "test", User.Role.USER)
            val mockHttpSession = MockHttpSession()
            mockHttpSession.setAttribute(UserPrincipal.SESSION_NAME, user)

            it("401 응답을 반환한다") {
                mockMvc
                    .perform(
                        delete("/api/products/$productId")
                            .session(mockHttpSession),
                    )
                    .andExpect(status().isUnauthorized)
            }
        }
    }
})
