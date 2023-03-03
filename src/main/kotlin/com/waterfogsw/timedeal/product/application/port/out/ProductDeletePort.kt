package com.waterfogsw.timedeal.product.application.port.out

import java.util.UUID

interface ProductDeletePort {

    fun delete(id: UUID)
}
