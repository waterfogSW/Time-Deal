package com.waterfogsw.timedeal.product.application.port.`in`

import com.waterfogsw.timedeal.product.domain.Product
import java.util.UUID

interface ProductLookupPort {

    fun findById(id: UUID): Product
}
