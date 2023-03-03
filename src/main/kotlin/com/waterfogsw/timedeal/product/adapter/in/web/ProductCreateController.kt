package com.waterfogsw.timedeal.product.adapter.`in`.web

import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductCreateRequest
import com.waterfogsw.timedeal.product.application.port.`in`.ProductCreateCommand
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/products")
class ProductCreateController(
    private val productCreateCommand: ProductCreateCommand,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody productCreateRequest: ProductCreateRequest) {
        productCreateCommand.create(productCreateRequest)
    }
}
