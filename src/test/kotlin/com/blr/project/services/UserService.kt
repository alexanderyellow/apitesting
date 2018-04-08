package com.blr.project.services

import com.blr.project.logger.Loggable
import io.restassured.RestAssured.given
import io.restassured.response.ValidatableResponse
import org.springframework.stereotype.Component

@Component
class UserService : AbstractClient() {

    private val path = "/api/unknown"

    @Loggable("Get user.")
    fun get(): ValidatableResponse {
        return given()
                .basePath(path)
                .`when`()
                .log().all()
                .get()
                .then()
                .log().all()
    }
}