package com.blr.project.tests

import com.blr.project.services.UserService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class UserTests: AbstractTest() {

    @Autowired
    private lateinit var userService: UserService

    @Test
    fun `test getUser service`() {
        userService.getUsers()
    }

    @Test
    fun `test 2`() {
        userService.getUser(1)
    }
}