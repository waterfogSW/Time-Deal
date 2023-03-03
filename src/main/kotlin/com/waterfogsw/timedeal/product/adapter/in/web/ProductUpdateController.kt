package com.waterfogsw.timedeal.product.adapter.`in`.web

import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductUpdateRequest
import com.waterfogsw.timedeal.product.application.port.`in`.ProductUpdateCommand
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("api/products")
class ProductUpdateController(
    private val productUpdateCommand: ProductUpdateCommand,
) {

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(
        @PathVariable id: UUID,
        @RequestBody productUpdateRequest: ProductUpdateRequest,
    ) {
        productUpdateCommand.update(id, productUpdateRequest)
    }
}
