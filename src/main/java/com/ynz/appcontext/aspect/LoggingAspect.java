package com.ynz.appcontext.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

/**
 * <p>Aspect is a cutting-across concern. It cuts into many classes.  This concern can be encapsulated in a class.
 * Meaning that, it can be re-used.</p>
 * <p>
 * Pointcut means that selecting a join point.
 */

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(Loggable)")
    public void executeLogging() {

    }

    //before advice
    @Before("executeLogging()")
    public void logMethodCall(JoinPoint joinPoint) {
        StringBuilder sb = new StringBuilder("Method: ");
        sb.append(joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            sb.append(" args=[ | ");
            Arrays.asList(args).forEach(arg -> {
                sb.append(arg).append(" | ");
            });
            sb.append("]");
        }
        LOGGER.info(sb.toString());
    }

    //advice to be executed after a joint point completes normally.
    @AfterReturning(value = "executeLogging()", returning = "returnValue")
    public void logAfterMethodCall(JoinPoint joinPoint, Object returnValue) {
        StringBuilder sb = new StringBuilder();

        sb.append("After advice: ");
        sb.append("JoinPoint is completed: ");

        if (returnValue instanceof Collection) {
            sb.append(((Collection) returnValue).size()).append(" instance(s) ");
        } else {
            sb.append("returnValue :" + returnValue);
        }

        LOGGER.info(sb.toString());
    }


}
