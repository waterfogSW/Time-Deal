package com.waterfogsw.timedeal.adapter.out.jpa

import com.waterfogsw.timedeal.adapter.out.jpa.mapper.MemberJpaMapper
import com.waterfogsw.timedeal.application.port.out.*
import com.waterfogsw.timedeal.common.exception.NotFoundException
import com.waterfogsw.timedeal.common.layer.Adapter
import com.waterfogsw.timedeal.domain.Member
import java.util.*

@Adapter
class MemberPersistenceAdapter(
    private val memberJpaRepository: MemberJpaRepository,
    private val memberJpaMapper: MemberJpaMapper,
) : MemberCreatePort, MemberDeletePort, MemberLookupPort {

    override fun create(member: Member): Member {
        val memberEntity = memberJpaMapper.mapToJpaEntity(member)
        val persistEntity = memberJpaRepository.save(memberEntity)
        return memberJpaMapper.mapToDomain(persistEntity)
    }

    override fun delete(id: UUID) {
        memberJpaRepository.deleteById(id)
    }

    override fun findByUsername(username: String): Member {
        val memberJpaEntity = memberJpaRepository.findByUsername(username)
            ?: throw NotFoundException("Member(username = $username) not found")

        return memberJpaMapper.mapToDomain(memberJpaEntity)
    }
}
