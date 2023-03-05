package com.waterfogsw.timedeal.product.adapter.`in`.web

import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductListRequest
import com.waterfogsw.timedeal.product.application.port.`in`.ProductListCommand
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/products")
class ProductListController(
    private val productListCommand: ProductListCommand,
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun list(productListRequest: ProductListRequest) = productListCommand.list(productListRequest)
}
