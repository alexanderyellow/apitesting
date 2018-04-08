package com.blr.project.logger

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

class Log {

    companion object {

        val logger: Logger = LoggerFactory.getLogger("binary_data_logger")

        fun info(message: String) = logger.info(message)

        fun info(file: File, message: String) = logger.info("RP_MESSAGE#FILE#{}#{}", file.getAbsolutePath(), message)

        fun debug(message: String) = logger.debug(message)

        /*fun error(message: String) {
        StatusManager.fail();
        LOGGER.error(message);
    }

    fun trace(String message) {
        LOGGER.trace(message);
    }

    fun trace(File file, String message) {
        LOGGER.trace("RP_MESSAGE#FILE#{}#{}", file.getAbsoluteFile(), message);
    }

    fun trace(String message, Object o) {
        LOGGER.trace(message, o);
    }

    fun warn(String message) {
        LOGGER.warn(message);
    }

    fun info(byte[] bytes, String message) {
        LOGGER.info("RP_MESSAGE#BASE64#{}#{}", BaseEncoding.base64().encode(bytes), message);
    }

    fun logBase64(String base64, String message) {
        LOGGER.info("RP_MESSAGE#BASE64#{}#{}", base64, message);
    }*/
    }
}