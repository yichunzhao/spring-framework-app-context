package com.ynz.appcontext.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CountingAspect {
    private static final Logger logger = LoggerFactory.getLogger(CountingAspect.class);
    private static int counter;

    @Pointcut("@annotation(Countable)")
    public void counting() {

    }

    @Before("counting()")
    public void countingMethodInvocation(JoinPoint joinPoint) {

        StringBuilder sb = new StringBuilder("The method : ").append(joinPoint.getSignature().getName()).append(" is called.");
        counter++;
        sb.append(" counter: "+counter );

        logger.info(sb.toString());
    }

}
