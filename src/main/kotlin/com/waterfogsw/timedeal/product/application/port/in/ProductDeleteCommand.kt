package com.waterfogsw.timedeal.product.application.port.`in`

import java.util.UUID

interface ProductDeleteCommand {

    fun delete(id: UUID)
}
