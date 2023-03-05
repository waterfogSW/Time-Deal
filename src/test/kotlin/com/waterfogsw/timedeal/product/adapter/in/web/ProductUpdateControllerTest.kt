package com.waterfogsw.timedeal.product.adapter.`in`.web

import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import com.waterfogsw.timedeal.common.exception.NotFoundException
import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductUpdateRequest
import com.waterfogsw.timedeal.product.application.port.`in`.ProductUpdateCommand
import com.waterfogsw.timedeal.util.restDocMockMvcBuild
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.restdocs.ManualRestDocumentation
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.requestFields
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.web.context.WebApplicationContext
import java.time.LocalDateTime

@DisplayName("WEB - 상품 수정 API")
@WebMvcTest(ProductUpdateController::class)
class ProductUpdateControllerTest(
    @Autowired private val context: WebApplicationContext,
    @Autowired private val objectMapper: ObjectMapper,
    @MockkBean private val productUpdateCommand: ProductUpdateCommand,
) : DescribeSpec({

    val restDocumentation = ManualRestDocumentation()
    val mockMvc = restDocMockMvcBuild(context, restDocumentation)

    beforeEach { restDocumentation.beforeTest(javaClass, it.name.testName) }
    afterEach { restDocumentation.afterTest() }

    describe("PUT /api/products/{id}") {

        val productId = 1L
        val productUpdateRequest = ProductUpdateRequest(
            name = "iPhone 13",
            description = "A new iPhone model from Apple",
            imageUrl = "https://example.com/image.jpg",
            quantity = 10,
            originalPrice = 1000000,
            sellingPrice = 1200000,
            dealEndTime = LocalDateTime
                .now()
                .plusDays(1),
        )

        context("상품이 존재하면") {

            every { productUpdateCommand.update(productId, productUpdateRequest) } just runs

            it("상품을 수정하고 200 응답을 반환한다") {
                mockMvc
                    .perform(
                        put("/api/products/$productId")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(productUpdateRequest)),
                    )
                    .andExpect(status().isOk)
                    .andDo(
                        document(
                            "update-product",
                            requestFields(
                                fieldWithPath("name").description("The name of the product"),
                                fieldWithPath("description").description("The description of the product"),
                                fieldWithPath("imageUrl").description("The URL of the image of the product"),
                                fieldWithPath("quantity").description("The quantity of the product"),
                                fieldWithPath("originalPrice").description("The original price of the product"),
                                fieldWithPath("sellingPrice").description("The selling price of the product"),
                                fieldWithPath("dealEndTime").description("The end time of product dealing"),
                            ),
                        ),
                    )

                verify { productUpdateCommand.update(productId, productUpdateRequest) }
            }
        }

        context("상품이 존재하지 않으면") {

            every {
                productUpdateCommand.update(
                    productId,
                    productUpdateRequest,
                )
            } throws NotFoundException()

            it("404 응답을 반환한다") {
                mockMvc
                    .perform(
                        put("/api/products/$productId")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(productUpdateRequest)),
                    )
                    .andExpect(status().isNotFound)
            }
        }
    }
})
