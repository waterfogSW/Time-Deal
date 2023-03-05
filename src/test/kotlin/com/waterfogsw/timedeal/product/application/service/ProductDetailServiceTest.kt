package com.waterfogsw.timedeal.product.application.service

import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductDetailResponse
import com.waterfogsw.timedeal.product.application.port.`in`.ProductLookupPort
import com.waterfogsw.timedeal.product.application.service.mapper.ProductDTOMapper
import com.waterfogsw.timedeal.product.domain.Product
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.*
import org.assertj.core.api.Assertions.assertThat
import java.time.LocalDateTime

@DisplayName("Service - 상품 상세 조회 기능")
class ProductDetailServiceTest : DescribeSpec({

    val productLookupPort = mockk<ProductLookupPort>()
    val productDTOMapper = mockk<ProductDTOMapper>()
    val productDetailService = ProductDetailService(productLookupPort, productDTOMapper)

    describe("detail(id)") {
        val productId = 1L
        val product = Product(
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

        every { productLookupPort.findById(productId) } returns product
        every { productDTOMapper.mapToDetailResponse(product) } returns productDetailResponse

        it("해당 id 값의 상품 상세를 반환한다") {
            val result = productDetailService.detail(productId)

            assertThat(productDetailResponse).isEqualTo(result)
            verify { productLookupPort.findById(productId) }
            verify { productDTOMapper.mapToDetailResponse(product) }
        }
    }
})
