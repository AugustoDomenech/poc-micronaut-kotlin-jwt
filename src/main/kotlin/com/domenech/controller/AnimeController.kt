package com.domenech.controller

import com.domenech.domain.entity.Anime
import com.domenech.service.AnimeService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*


@Controller(value = "/animes")
class AnimeController(val animeService: AnimeService) {

    @Get(value = "/{id}")
    fun findById(@PathVariable id: Long): HttpResponse<Anime> {
        return HttpResponse.ok( animeService.findById(id))
    }

    @Get(value = "/find/{name}")
    fun findByName( @PathVariable name: String ): HttpResponse<List<Anime>> {
        return HttpResponse.ok(animeService.findByName(name))
    }

    @Post
    fun save(@Body anime: Anime): HttpResponse<Anime> {
        return HttpResponse.created( animeService.save(anime) )
    }

    @Put("/{id}")
    fun replace(@PathVariable id: Long, @Body anime: Anime ): HttpResponse<Anime> {
        return HttpResponse.ok(animeService.replace(id, anime))
    }

    @Delete(value = "/{id}")
    fun delete(@PathVariable id: Long): HttpResponse<Void> {
        animeService.delete(id)
        return HttpResponse.noContent()
    }

}