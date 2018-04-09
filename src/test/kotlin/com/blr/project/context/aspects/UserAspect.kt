package com.blr.project.context.aspects

import com.blr.project.common.SERVICE_POINTCUT
import com.blr.project.logger.Loggable
import com.blr.project.logger.logger
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut

@Aspect
class UserAspect {

    @Pointcut(SERVICE_POINTCUT)
    fun servicePointcut() {
    }

    /**
     * Log service methods which is labeled by @Loggable annotation
     */
    @Around("servicePointcut() && @annotation(loggable)")
    fun logServices(pjp: ProceedingJoinPoint, loggable: Loggable): Any? {

        val comment = formatComment(loggable.value, pjp.args)

        logger(pjp.target.javaClass.name).debug(comment)
        return pjp.proceed()
    }

    /**
     * Comment formatting function. Substitute args in a pattern
     */
    private fun formatComment(comment: String, args: Array<Any>): String {
        var output = ""

        for ((index, value) in args.withIndex()) {
            output = comment.replace("{$index}", "$value")
        }

        return output
    }
}