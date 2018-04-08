package com.blr.project.context

import com.blr.project.logger.LoggerPrintStream
import com.blr.project.logger.logger
import io.restassured.RestAssured
import io.restassured.config.ConnectionConfig
import io.restassured.config.EncoderConfig
import io.restassured.config.LogConfig
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

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()

        val closeIdleConnectionConfig = ConnectionConfig.CloseIdleConnectionConfig(idleTime, TimeUnit.SECONDS)
        val loggerPrintStream = LoggerPrintStream(logger())

        RestAssured.config = RestAssured
                .config()
                .encoderConfig(EncoderConfig.encoderConfig().defaultContentCharset("UTF-8")
                        .encodeContentTypeAs("application-json", ContentType.JSON))
                .connectionConfig(ConnectionConfig.connectionConfig()
                        .closeIdleConnectionsAfterEachResponseAfter(closeIdleConnectionConfig))
                .logConfig(LogConfig(loggerPrintStream.getPrintStream(), true))


        /*RequestSpecBuilder()
                .addFilter(RequestLoggingFilter(LogDetail.ALL, true, loggerPrintStream.requestPrintStream()))
                .addFilter(ResponseLoggingFilter(LogDetail.ALL, true, loggerPrintStream.responsePrintStream()))*/
    }

}