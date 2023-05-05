package com.baizhi.dynamic;

import org.aopalliance.intercept.Joinpoint;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Before implements MethodBeforeAdvice {
    /*
    作用：需要把运行在原始方法执行之前运行的额外功能，书写在before方法中
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("执行方法："+method+"，"+method.getName());
    }

}
