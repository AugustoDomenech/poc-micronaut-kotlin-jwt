package com.domenech.repository

import com.domenech.domain.entity.UserSytem
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface UserSytemRepository: JpaRepository<UserSytem, Long> {
}