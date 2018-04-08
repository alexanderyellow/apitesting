package com.blr.project.logger

/**
 * Annotation for tagging loggable methods
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Loggable(val value: String = "")