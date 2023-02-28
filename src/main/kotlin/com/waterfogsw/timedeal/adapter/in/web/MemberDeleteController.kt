package com.waterfogsw.timedeal.adapter.`in`.web

import com.waterfogsw.timedeal.application.port.`in`.MemberDeleteCommand
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/members")
class MemberDeleteController(
  private val memberDeleteCommand: MemberDeleteCommand
) {

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  fun delete(@PathVariable id: String) {
    memberDeleteCommand.delete(id)
  }

}
