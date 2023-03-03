package com.waterfogsw.timedeal.product.application.port.`in`

import com.waterfogsw.timedeal.product.adapter.`in`.web.dto.ProductUpdateRequest
import java.util.*

interface ProductUpdateCommand {

    fun update(id: UUID, productUpdateRequest: ProductUpdateRequest)
}
