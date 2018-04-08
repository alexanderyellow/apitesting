package com.blr.project.context

import com.blr.project.logger.Log
import com.blr.project.logger.ToLoggerPrintStream
import io.restassured.RestAssured
import io.restassured.config.ConnectionConfig
import io.restassured.config.EncoderConfig
import io.restassured.config.LogConfig
import io.restassured.config.RestAssuredConfig
import io.restassured.http.ContentType
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class RestConfig {

    @Value("\${base.url}")
    lateinit var baseUrl: String

    @Value("\${idleTime}")
    var idleTime: Long = 500

    fun initialize() {
        RestAssured.baseURI = baseUrl
        RestAssured.useRelaxedHTTPSValidation()

        RestAssured.config = RestAssuredConfig()
                .encoderConfig(EncoderConfig.encoderConfig().defaultContentCharset("UTF-8")
                .encodeContentTypeAs("application-json", ContentType.JSON))

        val closeIdleConnectionConfig = ConnectionConfig.CloseIdleConnectionConfig(idleTime, TimeUnit.SECONDS)
        RestAssured
                .config()
                .connectionConfig(ConnectionConfig.connectionConfig()
                .closeIdleConnectionsAfterEachResponseAfter(closeIdleConnectionConfig))

        val loggerPrintStream = ToLoggerPrintStream(Log.logger)
        RestAssured.config = RestAssured
                .config()
                .logConfig(LogConfig(loggerPrintStream.getPrintStream(), true))
    }

}