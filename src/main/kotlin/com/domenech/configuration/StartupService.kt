package com.domenech.configuration

import com.domenech.domain.entity.UserSystem
import com.domenech.repository.UserSystemRepository
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.event.annotation.EventListener
import org.slf4j.LoggerFactory
import java.util.function.Consumer
import javax.inject.Singleton

@Singleton
class StartupService(val userSytemRepository: UserSystemRepository, val bCrypt: BCryptPasswordEncoderService) {

    private val log = LoggerFactory.getLogger( StartupService::class.java )

    @EventListener
    fun onStartupEvent(envent: StartupEvent) {
        if (!userSytemRepository.findByLogin("admin").isPresent)
            userSytemRepository.save(UserSystem(0, "admin", bCrypt.encode("admin")))
        log.info("Added User: Username: admin , Password: admin")
    }



}