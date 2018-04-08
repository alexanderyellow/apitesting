package com.blr.project.model

import com.blr.project.logger.Loggable
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
data class User(var login: String = "login", var password: String = "password"): Header() {

    @Value("\${admin.login}")
    private lateinit var adminLogin: String
    @Value("\${admin.password}")
    private lateinit var adminPassword: String

    fun admin(): User {
        return User(adminLogin, adminPassword)
    }

    @Loggable("Get something")
    fun getSomething(something: String): String {
        return something
    }
}