package com.domenech.service

import com.domenech.domain.entity.Anime
import com.domenech.repository.AnimeRepository
import io.micronaut.context.annotation.Executable
import java.util.*
import javax.inject.Singleton

@Singleton
class AnimeService(val repository: AnimeRepository) {

    fun save(anime: Anime): Anime {
        return repository.save(anime)
    }

    fun replace(id: Long, anime: Anime): Anime {
        val animeSaved = repository.findById(id);
        anime.id = animeSaved.get().id
        return repository.update(anime)
    }

    fun delete(id: Long) {
        val anime = repository.findById(id)
        repository.delete(anime.get())
    }

    fun findById(id: Long): Optional<Anime> {
        return repository.findById(id)
    }

    fun findByName(name: String): List<Anime> {
        return repository.findByName(name)
    }

}