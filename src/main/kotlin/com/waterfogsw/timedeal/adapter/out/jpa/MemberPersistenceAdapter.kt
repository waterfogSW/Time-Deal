package com.waterfogsw.timedeal.adapter.out.jpa

import com.waterfogsw.timedeal.adapter.out.jpa.mapper.MemberJpaMapper
import com.waterfogsw.timedeal.application.port.out.MemberCreatePort
import com.waterfogsw.timedeal.application.port.out.MemberDeletePort
import com.waterfogsw.timedeal.common.layer.PersistenceAdapter
import com.waterfogsw.timedeal.domain.Member
import java.util.UUID

@PersistenceAdapter
class MemberPersistenceAdapter (
  private val memberJpaRepository: MemberJpaRepository,
  private val memberJpaMapper: MemberJpaMapper
): MemberCreatePort, MemberDeletePort {

  override fun create(member: Member): Member {
    val memberEntity = memberJpaMapper.mapToJpaEntity(member)
    val persistEntity = memberJpaRepository.save(memberEntity)
    return memberJpaMapper.mapToDomain(persistEntity)
  }

  override fun delete(id: UUID) {
    memberJpaRepository.deleteById(id)
  }

}
