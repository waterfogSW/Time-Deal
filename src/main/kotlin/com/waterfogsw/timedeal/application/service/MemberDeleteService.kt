package com.waterfogsw.timedeal.application.service

import com.waterfogsw.timedeal.application.port.`in`.MemberDeleteCommand
import org.springframework.stereotype.Service

@Service
class MemberDeleteService : MemberDeleteCommand {

  override fun delete(id: String) {
    TODO("Not yet implemented")
  }

}
