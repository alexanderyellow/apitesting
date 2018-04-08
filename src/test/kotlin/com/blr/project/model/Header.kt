package com.blr.project.model

import com.blr.project.logger.Loggable
import org.springframework.stereotype.Component

@Component
class Header {
    @Loggable("Get header")
    fun getHeader(value: String) = value
}