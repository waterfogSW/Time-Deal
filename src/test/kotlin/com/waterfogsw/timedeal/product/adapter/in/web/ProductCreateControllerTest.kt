package com.waterfogsw.timedeal.product.adapter.`in`.web

import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductCreateRequest
import com.waterfogsw.timedeal.product.application.port.`in`.ProductCreateCommand
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

@DisplayName("WEB - 상품 등록 API")
@WebMvcTest(ProductCreateController::class)
class ProductCreateControllerTest(
    @Autowired private val context: WebApplicationContext,
    @Autowired private val objectMapper: ObjectMapper,
    @MockkBean private val productCreateCommand: ProductCreateCommand,
) : DescribeSpec({

    val restDocumentation = ManualRestDocumentation()
    val mockMvc = restDocMockMvcBuild(context, restDocumentation)

    beforeEach { restDocumentation.beforeTest(javaClass, it.name.testName) }
    afterEach { restDocumentation.afterTest() }

    describe("POST /api/products") {

        val productCreateRequest = ProductCreateRequest(
            name = "iPhone 13",
            description = "A new iPhone model from Apple",
            imageUrl = "https://example.com/image.jpg",
            quantity = 10,
            originalPrice = 1000000,
            sellingPrice = 1200000,
        )

        every { productCreateCommand.create(productCreateRequest) } just runs

        it("상품을 등록한다") {
            mockMvc
                .perform(
                    post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productCreateRequest)),
                )
                .andExpect(status().isCreated)
                .andDo(
                    document(
                        "create-product",
                        requestFields(
                            fieldWithPath("name").description("The name of the product"),
                            fieldWithPath("description").description("The description of the product"),
                            fieldWithPath("imageUrl").optional().description("The URL of the image of the product"),
                            fieldWithPath("quantity").description("The quantity of the product"),
                            fieldWithPath("originalPrice").description("The original price of the product"),
                            fieldWithPath("sellingPrice").description("The selling price of the product"),
                        ),
                    ),
                )

            verify { productCreateCommand.create(productCreateRequest) }
        }
    }
})
