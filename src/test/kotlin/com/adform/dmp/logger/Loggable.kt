package com.adform.dmp.logger

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Loggable(val value: String = "")