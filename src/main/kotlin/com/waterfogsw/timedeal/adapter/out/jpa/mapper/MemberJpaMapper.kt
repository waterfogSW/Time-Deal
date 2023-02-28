package com.waterfogsw.timedeal.adapter.out.jpa.mapper

import com.waterfogsw.timedeal.adapter.out.jpa.MemberJpaEntity
import com.waterfogsw.timedeal.domain.Member
import org.springframework.stereotype.Component

@Component
class MemberJpaMapper {

  fun mapToDomain(memberJpaEntity: MemberJpaEntity) =
    Member(
      id = memberJpaEntity.id.toString(),
      username = memberJpaEntity.username,
      password = memberJpaEntity.password,
    )

  fun mapToJpaEntity(member: Member) =
    MemberJpaEntity(
      username = member.username,
      password = member.password
    )

}
