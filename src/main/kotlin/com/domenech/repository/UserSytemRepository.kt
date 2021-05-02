package com.domenech.repository

import com.domenech.domain.entity.UserSystem
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface UserSystemRepository: JpaRepository<UserSystem, Long> {

    fun findByLogin(login: String): Optional<UserSystem>
}