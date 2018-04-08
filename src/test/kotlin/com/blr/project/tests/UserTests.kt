package com.blr.project.tests

import com.blr.project.model.User
import com.blr.project.services.UserService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class UserTests: AbstractTest() {

    @Autowired
    private lateinit var userService: UserService

    private var user = User()

    @Test
    fun `test get all users`() {
        userService.get()
    }

    @Test
    fun `test get user`() {
        userService.get(1)
    }

    @Test
    fun `test create user`() {
        userService.create(user)
    }

    @Test
    fun `test update user`() {
        userService.update(1, User())
    }

    @Test
    fun `test delete user`() {
        userService.delete(1)
    }
}