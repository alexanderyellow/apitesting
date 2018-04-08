package com.blr.project.logger

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.util.*

class APILogger {

    companion object {
        private val LOGGER = LoggerFactory.getLogger("data_logger")

        fun get(): Logger {
            return LOGGER
        }

        fun info(message: String) {
            LOGGER.info(message)
        }

        fun info(file: File, message: String) {
            Objects.requireNonNull(file)
            LOGGER.info("RP_MESSAGE#FILE#{}#{}", file.absolutePath, message)
        }

        fun debug(message: String) {
            LOGGER.debug(message)
        }
    }
}