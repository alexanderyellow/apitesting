package com.adform.dmp.context.aspects

import com.adform.dmp.logger.Loggable
import com.adform.dmp.logger.logger
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut

@Aspect
class UserAspect {
    /*@Before("getNamePointcut()")
    fun getNameAdvice() {
        println("Executing Advice on getSomething()")
    }*/

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
        logger(pjp.target.javaClass.name).debug(loggable.value)
        return pjp.proceed()
    }

    @Around("servicePointcut() && @annotation(loggable)")
    fun logServices(pjp: ProceedingJoinPoint, loggable: Loggable): Any? {
        logger(pjp.target.javaClass.name).debug(loggable.value)
        return pjp.proceed()
    }
}