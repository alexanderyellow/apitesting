package com.blr.project.extensions

import com.blr.project.logger.logger
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.slf4j.Logger

class TestExtension : BeforeAllCallback, AfterEachCallback, BeforeEachCallback {
    private lateinit var testLogger: Logger

    override fun beforeAll(context: ExtensionContext?) {
        testLogger = logger(context!!.requiredTestClass.name)
    }

    override fun beforeEach(context: ExtensionContext?) {
        testLogger.info("*** Start test: ${context!!.requiredTestMethod.name} ***\n")
    }

    override fun afterEach(context: ExtensionContext?) {
        testLogger.info("*** Finish test: ${context!!.requiredTestMethod.name} ***\n")
    }

}