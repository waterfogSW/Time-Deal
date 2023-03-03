package com.waterfogsw.timedeal.product.application.service

import com.waterfogsw.timedeal.product.application.port.out.ProductDeletePort
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.*
import java.util.UUID

@DisplayName("Service - 상품 삭제 기능")
class ProductDeleteServiceTest : DescribeSpec({

    val productId = UUID.randomUUID()
    val productDeletePort = mockk<ProductDeletePort>()
    val productDeleteService = ProductDeleteService(productDeletePort)

    describe("delete(id)") {

        it("상품을 삭제한다") {
            every { productDeletePort.delete(productId) } just runs

            productDeleteService.delete(productId)

            verify { productDeletePort.delete(productId) }
        }
    }
})
