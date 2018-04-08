package com.blr.project.services

import com.blr.project.logger.Loggable
import com.blr.project.model.User
import com.blr.project.utils.convertPath
import io.restassured.response.ValidatableResponse
import org.springframework.stereotype.Component

@Component
class UserService : AbstractClient() {

    private val GET_USERS = "/api/users"
    private val GET_USER = GET_USERS + "/{id}"

    @Loggable("Get user.")
    fun get(): ValidatableResponse {
        return get(GET_USERS)
    }

    @Loggable("Get specific user by id={0}.")
    fun get(id: Int): ValidatableResponse {
        val path = convertPath(GET_USER, id)
        return get(path)
    }

    @Loggable("Create user: {0}.")
    fun create(user: User): ValidatableResponse {
        return post(GET_USERS, user)
    }

    @Loggable("Update user id: {0}. New user: {1}")
    fun update(id: Int, newUser: User): ValidatableResponse {
        val path = convertPath(GET_USER, id)
        return put(path, newUser)
    }

    @Loggable("Delete user id: {0}")
    fun delete(id: Int): ValidatableResponse {
        val path = convertPath(GET_USER, id)
        return delete(path)
    }
}