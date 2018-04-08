package com.blr.project.utils

import java.util.*

/**
 * Generate random string
 */
fun randomString(prefix: String = "") = "${prefix}_${Date().time}"