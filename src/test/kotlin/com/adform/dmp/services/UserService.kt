package com.adform.dmp.services

import com.adform.dmp.logger.Loggable
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import io.restassured.response.ValidatableResponse
import org.springframework.stereotype.Component

@Component
class UserService {

    //companion object {
    private val path = "/api/unknown/2"

    @Loggable("Get user.")
    fun get(): ValidatableResponse {
        //println("lalala " + baseUrl)
        return given()
                //.baseUri(baseUrl)
                .basePath(path)
                .contentType(ContentType.JSON)
                .`when`()
                .log().all()
                .get()
                .then()
                .log().all()
    }
}