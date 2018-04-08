package com.adform.dmp.tests

import com.adform.dmp.services.UserService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class HelloTest: AbstractTest() {

    @Autowired
    private lateinit var userService: UserService

    @Test
    fun testUserService() {
        
    }
}