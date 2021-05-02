package com.domenech.repository

import com.domenech.domain.entity.Anime
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface AnimeRepository: JpaRepository<Anime, Long> {

    fun findByName(name: String): List<Anime>

}