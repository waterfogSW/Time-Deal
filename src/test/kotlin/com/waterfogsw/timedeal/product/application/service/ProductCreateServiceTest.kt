package com.waterfogsw.timedeal.product.application.service

import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductCreateRequest
import com.waterfogsw.timedeal.product.application.port.out.ProductCreatePort
import com.waterfogsw.timedeal.product.application.service.mapper.ProductDTOMapper
import com.waterfogsw.timedeal.product.domain.Product
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.*
import java.util.*

@DisplayName("Service - 상품 등록 기능")
class ProductCreateServiceTest : DescribeSpec({

    val productDTOMapper = mockk<ProductDTOMapper>()
    val productCreatePort = mockk<ProductCreatePort>()
    val productCreateService = ProductCreateService(productDTOMapper, productCreatePort)

    describe("create(productCreateRequest)") {

        val productCreateRequest = ProductCreateRequest(
            name = "iPhone 13",
            description = "A new iPhone model from Apple",
            imageUrl = "https://example.com/image.jpg",
            quantity = 10,
            originalPrice = 1000000,
            sellingPrice = 1200000,
        )

        val product = Product(
            name = productCreateRequest.name,
            description = productCreateRequest.description,
            imageUrl = productCreateRequest.imageUrl,
            quantity = productCreateRequest.quantity,
            originalPrice = productCreateRequest.originalPrice,
            sellingPrice = productCreateRequest.sellingPrice,
        )

        it("상품을 등록한다") {
            every { productDTOMapper.mapToDomain(productCreateRequest) } returns product
            every { productCreatePort.create(product) } returns product.copy(id = UUID.randomUUID())

            productCreateService.create(productCreateRequest)

            verify { productDTOMapper.mapToDomain(productCreateRequest) }
            verify { productCreatePort.create(product) }
        }
    }
})
