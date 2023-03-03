package com.waterfogsw.timedeal.product.adapter.`in`.web

import com.waterfogsw.timedeal.common.annotation.Auth
import com.waterfogsw.timedeal.product.application.port.`in`.ProductDeleteCommand
import com.waterfogsw.timedeal.user.domain.User.Role.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("api/products")
class ProductDeleteController(
    private val productDeleteCommand: ProductDeleteCommand,
) {

    @Auth([ADMIN])
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable id: UUID) {
        productDeleteCommand.delete(id)
    }
}
