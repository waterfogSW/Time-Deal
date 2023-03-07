package com.waterfogsw.timedeal.order.adapter.`in`.web

import com.ninjasquad.springmockk.MockkBean
import com.waterfogsw.timedeal.order.port.`in`.OrderCreateCommand
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
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post
import org.springframework.restdocs.request.RequestDocumentation.parameterWithName
import org.springframework.restdocs.request.RequestDocumentation.pathParameters
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.web.context.WebApplicationContext

@DisplayName("WEB - 주문 생성 API")
@WebMvcTest(OrderCreateController::class)
class OrderCreateControllerTest(
    @Autowired private val context: WebApplicationContext,
    @MockkBean private val orderCreateCommand: OrderCreateCommand,
) : DescribeSpec({

    val restDocumentation = ManualRestDocumentation()
    val mockMvc = restDocMockMvcBuild(context, restDocumentation)

    beforeEach { restDocumentation.beforeTest(javaClass, it.name.testName) }
    afterEach { restDocumentation.afterTest() }

    describe("POST /api/products/{productId}/orders") {

        context("사용자가 로그인 했을 때") {

            val user = UserPrincipal(1L, "test", User.Role.USER)
            val mockHttpSession = MockHttpSession()
            mockHttpSession.setAttribute(UserPrincipal.SESSION_NAME, user)

            val productId = 1L

            every { orderCreateCommand.create(any(), any()) } just runs

            it("상품을 주문하고 200 응답을 반환한다") {
                mockMvc
                    .perform(
                        post("/api/products/{productId}/orders", productId)
                            .session(mockHttpSession),
                    )
                    .andExpect(status().isCreated)
                    .andDo(
                        document(
                            "create-order",
                            pathParameters(
                                parameterWithName("productId").description("The ID of the product to order"),
                            ),
                        ),
                    )

                verify { orderCreateCommand.create(1L, user.id) }
            }
        }

        context("사용자가 로그인하지 않았을 때") {

            it("401 응답을 반환한다") {
                mockMvc
                    .perform(
                        post("/api/products/1/orders"),
                    )
                    .andExpect(status().isUnauthorized)
            }
        }
    }
})
