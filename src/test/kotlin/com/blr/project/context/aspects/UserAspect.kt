package com.blr.project.context.aspects

import com.blr.project.logger.Loggable
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut

@Aspect
class UserAspect {

    @Pointcut("execution(* com.adform.dmp.model.*.get*(*))")
    fun modelPointcut() {
    }

    @Pointcut("execution(* com.adform.dmp.services.*.*(*))")
    fun servicePointcut() {
    }

    /*@Before("getNamePointcut() && args(value))")
    fun logStringArguments(value: String) {
        println("String argument passed=$value")
    }*/

    @Around("modelPointcut() && @annotation(loggable)")
    fun logModel(pjp: ProceedingJoinPoint, loggable: Loggable): Any? {
        return pjp.proceed()
    }

    @Around("servicePointcut() && @annotation(loggable)")
    fun logServices(pjp: ProceedingJoinPoint, loggable: Loggable): Any? {
        return pjp.proceed()
    }
}