package com.waterfogsw.timedeal.user.adapter.out.jpa

import com.waterfogsw.timedeal.common.annotation.Adapter
import com.waterfogsw.timedeal.common.exception.NotFoundException
import com.waterfogsw.timedeal.user.adapter.out.jpa.mapper.UserJpaMapper
import com.waterfogsw.timedeal.user.application.port.out.*
import com.waterfogsw.timedeal.user.domain.User

@Adapter
class UserPersistenceAdapter(
    private val userJpaRepository: UserJpaRepository,
    private val userJpaMapper: UserJpaMapper,
) : UserSavePort, UserDeletePort, UserLookupPort {

    override fun save(user: User): User {
        val memberEntity = userJpaMapper.mapToJpaEntity(user)
        val persistEntity = userJpaRepository.save(memberEntity)
        return userJpaMapper.mapToDomain(persistEntity)
    }

    override fun delete(id: Long) {
        userJpaRepository.deleteById(id)
    }

    override fun findByUsername(username: String): User {
        val memberJpaEntity = userJpaRepository.findByUsername(username)
            ?: throw NotFoundException("Member(username = $username) not found")

        return userJpaMapper.mapToDomain(memberJpaEntity)
    }
}
