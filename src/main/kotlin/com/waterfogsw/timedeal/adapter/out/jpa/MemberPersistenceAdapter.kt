package com.waterfogsw.timedeal.adapter.out.jpa

import com.waterfogsw.timedeal.application.port.out.MemberCreatePort
import com.waterfogsw.timedeal.common.layer.PersistenceAdapter
import com.waterfogsw.timedeal.domain.Member

@PersistenceAdapter
class MemberPersistenceAdapter : MemberCreatePort {

  override fun create(member: Member): Member {
    TODO("Not yet implemented")
  }

}
