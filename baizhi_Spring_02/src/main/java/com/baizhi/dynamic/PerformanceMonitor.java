package com.baizhi.dynamic;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

public class PerformanceMonitor {
    @Around("execution(* com.baizhi.proxy.*.*(..))")
    public Object monitor(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = pjp.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println(pjp.getSignature() + " executed in " + (endTime - startTime) + "ms");
        return result;
    }
}
