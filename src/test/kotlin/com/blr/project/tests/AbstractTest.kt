package com.blr.project.tests

import com.blr.project.context.RestConfig
import com.blr.project.context.TestConfig
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
//@SpringJUnitConfig(TestConfig::class)
@ContextConfiguration(classes = [TestConfig::class])
open class AbstractTest {

    @Autowired
    lateinit var restConfig: RestConfig

    @BeforeAll
    fun beforeAll() {
        restConfig.initialize()
    }

}