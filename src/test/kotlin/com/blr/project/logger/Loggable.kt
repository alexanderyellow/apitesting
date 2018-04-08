package com.blr.project.logger

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Loggable(val value: String = "")