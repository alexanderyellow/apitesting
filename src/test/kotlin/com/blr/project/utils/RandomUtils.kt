package com.blr.project.utils

import java.util.*

/**
 * Generate random string
 */

object RandomUtils {
    fun randomString(prefix: String = ""): String {
        return "${prefix}_${Date().time}"
    }
}