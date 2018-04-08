package com.adform.dmp.model

import com.adform.dmp.logger.Loggable
import org.springframework.stereotype.Component

@Component
class Header {
    @Loggable("Get header")
    fun getHeader(value: String) = value
}