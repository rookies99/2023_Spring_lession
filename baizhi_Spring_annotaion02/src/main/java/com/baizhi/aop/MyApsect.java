package com.baizhi.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyApsect {

    @Pointcut("execution(* com.baizhi.aop..*.*(..))")
    public void pointCut(){}

    @Around("pointCut()")
    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("-----log-----");
        Object proceed = joinPoint.proceed();
        return proceed;
    }
}
