package com.blr.project.services

import io.restassured.RestAssured
import io.restassured.http.Method
import io.restassured.mapper.ObjectMapperType
import io.restassured.response.Response
import io.restassured.response.ValidatableResponse
import io.restassured.specification.RequestSpecification
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.anyOf

open class AbstractClient {

    /**
     * List of valid status codes
     */
    private val statusCodeMatcher: Matcher<Int> =
            anyOf<Int>(`is`<Int>(200), `is`<Int>(201), `is`<Int>(202), `is`<Int>(204))

    /**
     * Common method for get requests
     */
    fun get(path: String): ValidatableResponse {
        val requestSpecification =
                RestAssured
                        .given()
                .basePath(path)

        return response(Method.GET, requestSpecification)
    }

    /**
     * Common method for post requests
     */
    fun post(path: String, body: Any): ValidatableResponse {
        val requestSpecification =
                RestAssured
                        .given()
                        .basePath(path)
                        .body(body, ObjectMapperType.JACKSON_2)

        return response(Method.POST, requestSpecification)
    }

    /**
     * Common method for put requests
     */
    fun put(path: String, body: Any): ValidatableResponse {
        val requestSpecification =
                RestAssured
                        .given()
                        .basePath(path)
                        .body(body, ObjectMapperType.GSON)

        return response(Method.PUT, requestSpecification)
    }

    /**
     * Common method for delete requests
     */
    fun delete(path: String): ValidatableResponse {
        val requestSpecification =
                RestAssured
                        .given()
                        .basePath(path)

        return response(Method.DELETE, requestSpecification)
    }

    /**
     * Common response method. Send request and form response
     */
    private fun response(methos: Method, requestSpecification: RequestSpecification): ValidatableResponse {

        var response: Response? = null

        when(methos) {
            Method.GET -> response = requestSpecification.`when`()
                    .log().all()
                    .get()

            Method.POST -> response = requestSpecification.`when`()
                    .log().all()
                    .post()

            Method.PUT -> response = requestSpecification.`when`()
                    .log().all()
                    .put()

            Method.DELETE -> response = requestSpecification.`when`()
                    .log().all()
                    .delete()
        }

        return response!!
                .then()
                .log().all()
                .statusCode(statusCodeMatcher)
    }


}