package com.domenech.configuration

import com.domenech.repository.UserSystemRepository
import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.*
import io.reactivex.Flowable
import org.reactivestreams.Publisher
import javax.inject.Singleton

@Singleton
class UserSystemPasswordAuthenticationProvider(
    val userSystemRepository: UserSystemRepository,
    val bCrypt: BCryptPasswordEncoderService
) : AuthenticationProvider {
    override fun authenticate(
        httpRequest: HttpRequest<*>?,
        authenticationRequest: AuthenticationRequest<*, *>?
    ): Publisher<AuthenticationResponse> {
        val user = userSystemRepository.findByLogin(authenticationRequest?.identity.toString())
        if (!user.isPresent) {
            return Flowable.error(AuthenticationException(AuthenticationFailed(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH)))
        }

        if (!bCrypt.matches(authenticationRequest?.secret as String, user.get().password)) {
            return Flowable.error(AuthenticationException(AuthenticationFailed(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH)))
        }

        return Flowable.just(UserDetails(user.get().login, listOf()))

    }
}