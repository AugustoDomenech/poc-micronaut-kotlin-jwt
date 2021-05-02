package com.domenech

import com.domenech.domain.entity.UserSystem
import com.domenech.repository.UserSystemRepository
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.event.annotation.EventListener
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class StartupService(val userSytemRepository: UserSystemRepository) {

    private val log = LoggerFactory.getLogger( StartupService::class.java )

    @EventListener
    fun onStartupEvent(envent: StartupEvent) {
        var user = UserSystem(id = 0, login = "admin", password = "admin")
        userSytemRepository.findById(1).orElse(userSytemRepository.save(user))
        log.info("Added User: Username: admin , Password: admin")
    }



}