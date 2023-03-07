package com.waterfogsw.timedeal.order.adapter.`in`.web

import com.waterfogsw.timedeal.common.annotation.Auth
import com.waterfogsw.timedeal.common.annotation.Principal
import com.waterfogsw.timedeal.order.port.`in`.OrderCreateCommand
import com.waterfogsw.timedeal.user.domain.User.Role.*
import com.waterfogsw.timedeal.user.domain.UserPrincipal
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/products/{productId}/orders")
class OrderCreateController(
    private val orderCreateCommand: OrderCreateCommand,
) {

    @Auth([USER])
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @PathVariable
        productId: Long,
        @Principal
        userPrincipal: UserPrincipal,
    ) {
        orderCreateCommand.create(productId, userPrincipal.id)
    }
}
