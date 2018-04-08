package com.blr.project.common

//Pointcuts
const val MODEL_POINTCUT = "execution(* com.blr.project.model.*.get*(*))"

const val SERVICE_POINTCUT = "execution(* com.blr.project.services.*.*()) || execution(* com.blr.project.services.*.*(*))"

//Test config
const val CONFIG_PROPERTY = "classpath:config.properties"

const val COMPONENT_SCAN = "com.blr.project.*"