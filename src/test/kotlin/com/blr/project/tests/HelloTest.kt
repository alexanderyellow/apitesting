package com.blr.project.tests

import com.blr.project.services.UserService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class HelloTest: AbstractTest() {

    @Autowired
    private lateinit var userService: UserService

    @Test
    fun testUserService() {
        
    }
}