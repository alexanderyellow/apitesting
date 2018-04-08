package com.blr.project.logger

import org.slf4j.LoggerFactory

fun logger(name: String = "data_logger") = LoggerFactory.getLogger(name)