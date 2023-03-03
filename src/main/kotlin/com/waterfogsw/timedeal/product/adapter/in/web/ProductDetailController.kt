package com.waterfogsw.timedeal.product.adapter.`in`.web

import com.waterfogsw.timedeal.product.application.port.`in`.ProductDetailCommand
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/products")
class ProductDetailController(
    private val productDetailCommand: ProductDetailCommand,
) {

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun detail(@PathVariable id: Long) = productDetailCommand.detail(id)
}
