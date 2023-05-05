package com.baizhi.dynamic;

import com.baizhi.proxy.UserService;
import com.baizhi.proxy.UserServiceImpl;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

public class PerformanceMonitor {
    private static final Logger log = Logger.getLogger(UserService.class);
    @Around("execution(* com.baizhi.proxy.*.*(..))")
    public Object monitor(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = pjp.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println(pjp.getSignature() + " executed in " + (endTime - startTime) + "ms");
        if ((endTime - startTime)>100) {
            log.warn("性能消耗过大");
        }
        return result;
    }
}
