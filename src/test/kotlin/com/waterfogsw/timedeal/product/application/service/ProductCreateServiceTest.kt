package com.waterfogsw.timedeal.product.application.service

import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductCreateRequest
import com.waterfogsw.timedeal.product.application.port.out.ProductSavePort
import com.waterfogsw.timedeal.product.application.service.mapper.ProductDTOMapper
import com.waterfogsw.timedeal.product.domain.Product
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.*
import java.time.LocalDateTime
import java.util.*

@DisplayName("Service - 상품 등록 기능")
class ProductCreateServiceTest : DescribeSpec({

    val productDTOMapper = mockk<ProductDTOMapper>()
    val productSavePort = mockk<ProductSavePort>()
    val productCreateService = ProductCreateService(productDTOMapper, productSavePort)

    describe("create(productCreateRequest)") {

        val productCreateRequest = ProductCreateRequest(
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

        val product = Product(
            name = productCreateRequest.name,
            description = productCreateRequest.description,
            imageUrl = productCreateRequest.imageUrl,
            quantity = productCreateRequest.quantity,
            originalPrice = productCreateRequest.originalPrice,
            sellingPrice = productCreateRequest.sellingPrice,
            dealEndTime = LocalDateTime
                .now()
                .plusDays(1),
        )

        it("상품을 등록한다") {
            every { productDTOMapper.mapToDomain(productCreateRequest) } returns product
            every { productSavePort.save(product) } returns product.copy(id = 1L)

            productCreateService.create(productCreateRequest)

            verify { productDTOMapper.mapToDomain(productCreateRequest) }
            verify { productSavePort.save(product) }
        }
    }
})
