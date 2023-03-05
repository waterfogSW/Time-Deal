package com.waterfogsw.timedeal.product.adapter.`in`.web

import com.ninjasquad.springmockk.MockkBean
import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductListRequest
import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductListResponse
import com.waterfogsw.timedeal.product.application.port.`in`.ProductListCommand
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
import org.springframework.restdocs.request.RequestDocumentation.queryParameters
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.web.context.WebApplicationContext
import java.time.LocalDateTime
import java.util.*

@DisplayName("WEB - 상품 목록 조회 API")
@WebMvcTest(ProductListController::class)
class ProductListControllerTest(
    @Autowired private val context: WebApplicationContext,
    @MockkBean private val productListCommand: ProductListCommand,
) : DescribeSpec({

    val restDocumentation = ManualRestDocumentation()
    val mockMvc = restDocMockMvcBuild(context, restDocumentation)

    beforeEach { restDocumentation.beforeTest(javaClass, it.name.testName) }
    afterEach { restDocumentation.afterTest() }

    describe("GET /api/products") {
        val id = 2L
        val size = 10L
        val productListRequest = ProductListRequest(id, size)

        val productInfoList = listOf(
            ProductListResponse.ProductInfo(
                id = 2L,
                name = "Galaxy S21",
                description = "A new Galaxy model from Samsung",
                imageUrl = "https://example.com/image.jpg",
                quantity = 20L,
                originalPrice = 900000L,
                sellingPrice = 1000000L,
                dealEndTime = LocalDateTime
                    .now()
                    .plusDays(2L),
            ),
            ProductListResponse.ProductInfo(
                id = 1L,
                name = "iPhone 13",
                description = "A new iPhone model from Apple",
                imageUrl = "https://example.com/image.jpg",
                quantity = 10L,
                originalPrice = 1000000L,
                sellingPrice = 1200000L,
                dealEndTime = LocalDateTime
                    .now()
                    .plusDays(1L),
            ),
        )

        every { productListCommand.list(productListRequest) } returns ProductListResponse(
            productInfoList,
        )

        it("상품 목록을 조회하고 200 응답을 반환한다") {
            mockMvc
                .perform(
                    get("/api/products")
                        .param("id", id.toString())
                        .param("size", size.toString())
                        .contentType(MediaType.APPLICATION_JSON),
                )
                .andExpect(status().isOk)
                .andDo(
                    document(
                        "list-products",
                        queryParameters(
                            parameterWithName("id")
                                .description("The id of the product to start with")
                                .optional(),
                            parameterWithName("size")
                                .description("The number of products to return (default 10)")
                                .optional(),
                        ),
                        responseFields(
                            fieldWithPath("productInfos[]").description("List of product information"),
                            fieldWithPath("productInfos[].id").description("The ID of the product"),
                            fieldWithPath("productInfos[].name").description("The name of the product"),
                            fieldWithPath("productInfos[].description").description("The description of the product"),
                            fieldWithPath("productInfos[].imageUrl").description("The URL of the product image"),
                            fieldWithPath("productInfos[].quantity").description("The quantity of the product"),
                            fieldWithPath("productInfos[].originalPrice").description("The original price of the product"),
                            fieldWithPath("productInfos[].sellingPrice").description("The selling price of the product"),
                            fieldWithPath("productInfos[].dealEndTime").description("The end time of the product deal"),
                        ),
                    ),
                )

            verify { productListCommand.list(productListRequest) }
        }
    }
})
