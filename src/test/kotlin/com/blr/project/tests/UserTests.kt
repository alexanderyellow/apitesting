package com.blr.project.tests

import com.blr.project.model.User
import com.blr.project.services.UserService
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import kotlin.test.assertNotNull

/**
 * Test class contains test methods with the simplest checks
 */
class UserTests : AbstractTest() {

    @Autowired
    private lateinit var userService: UserService

    private var user = User()
    private val userId = 1
    private val jsonProperty = "data"


    @Test
    fun `test get all users`() {
        userService.get()
                .body(jsonProperty, hasSize<List<User>>(3))
                .assertThat()
    }

    @Test
    fun `test get user`() {
        userService.get(userId)
                .body(jsonProperty, notNullValue<User>(User::class.java))
                .assertThat()
    }

    @Test
    fun `test create user`() {
        val createdUser = userService.create(user)
                .extract()
                .`as`(User::class.java)

        assertNotNull(createdUser, "User was created incorrectly.")
    }

    @Test
    fun `test update user`() {
        val updatedUser = userService.update(userId, User())
                .extract()
                .`as`(User::class.java)

        assertNotNull(updatedUser, "User was updated incorrectly.")
    }

    @Test
    fun `test delete user`() {
        userService.delete(userId)
                .body(isEmptyOrNullString())
                .assertThat()
    }
}