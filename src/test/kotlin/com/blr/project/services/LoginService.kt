package com.blr.project.services

import org.springframework.stereotype.Component

@Component
class LoginService: AbstractClient() {

    //better save all urls in file
    private val URI = "/v1/token"

    /*fun login(user: User): String? {
        return client().post().uri(URI)
                .body(BodyInserters.fromObject(
                        mapOf("grant_type" to "password",
                        "username" to user.login,
                        "password" to user.password)))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono<String>()
                .block()
    }

    fun loginTemplate(user: User): String {
        restClient().
    }*/

}