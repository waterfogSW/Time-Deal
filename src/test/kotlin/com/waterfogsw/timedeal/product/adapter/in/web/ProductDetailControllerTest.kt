package com.waterfogsw.timedeal.product.adapter.`in`.web

import com.ninjasquad.springmockk.MockkBean
import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductDetailResponse
import com.waterfogsw.timedeal.product.application.port.`in`.ProductDetailCommand
import com.waterfogsw.timedeal.util.restDocMockMvcBuild
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.restdocs.ManualRestDocumentation
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import org.springframework.restdocs.request.RequestDocumentation.parameterWithName
import org.springframework.restdocs.request.RequestDocumentation.pathParameters
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.web.context.WebApplicationContext
import java.time.LocalDateTime

@DisplayName("WEB - 상품 조회 API")
@WebMvcTest(ProductDetailController::class)
class ProductDetailControllerTest(
    @Autowired private val context: WebApplicationContext,
    @MockkBean private val productDetailCommand: ProductDetailCommand,
) : DescribeSpec({

    val restDocumentation = ManualRestDocumentation()
    val mockMvc = restDocMockMvcBuild(context, restDocumentation)

    beforeEach { restDocumentation.beforeTest(javaClass, it.name.testName) }
    afterEach { restDocumentation.afterTest() }

    describe("GET /api/products/{id}") {

        val productId = 1L
        val productDetailResponse = ProductDetailResponse(
            id = productId,
            name = "iPhone 13",
            description = "A new iPhone model from Apple",
            imageUrl = "https://example.com/image.jpg",
            quantity = 10,
            originalPrice = 1000000,
            sellingPrice = 1200000,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),
            dealEndTime = LocalDateTime
                .now()
                .plusDays(1),
        )

        every { productDetailCommand.detail(productId) } returns productDetailResponse

        it("상품을 조회한다") {
            mockMvc
                .perform(
                    get("/api/products/{id}", productId)
                        .accept(MediaType.APPLICATION_JSON),
                )
                .andExpect(status().isOk)
                .andDo(
                    document(
                        "product-detail",
                        pathParameters(
                            parameterWithName("id").description("The id of the product to retrieve"),
                        ),
                        responseFields(
                            fieldWithPath("id").description("The ID of the product"),
                            fieldWithPath("name").description("The name of the product"),
                            fieldWithPath("description").description("The description of the product"),
                            fieldWithPath("imageUrl").description("The URL of the image of the product"),
                            fieldWithPath("quantity").description("The quantity of the product"),
                            fieldWithPath("originalPrice").description("The original price of the product"),
                            fieldWithPath("sellingPrice").description("The selling price of the product"),
                            fieldWithPath("createdAt").description("The date and time the product was created"),
                            fieldWithPath("updatedAt").description("The date and time the product was last updated"),
                            fieldWithPath("dealEndTime").description("The end time of product dealing"),
                        ),
                    ),
                )

            verify { productDetailCommand.detail(productId) }
        }
    }
})
