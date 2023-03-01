package com.waterfogsw.timedeal.member.application.service

import com.waterfogsw.timedeal.member.application.port.`in`.MemberDeleteCommand
import com.waterfogsw.timedeal.member.application.port.out.MemberDeletePort
import org.springframework.stereotype.Service
import java.util.*

@Service
class MemberDeleteService(
    private val memberDeletePort: MemberDeletePort,
) : MemberDeleteCommand {

    override fun delete(id: String) {
        memberDeletePort.delete(UUID.fromString(id))
    }
}