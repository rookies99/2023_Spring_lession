package com.baizhi.dynamic;

import org.aopalliance.intercept.Joinpoint;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Before implements MethodBeforeAdvice {
    /*
    作用：需要把运行在原始方法执行之前运行的额外功能，书写在before方法中
    参数详解：
            Method:指的是额外功能所增加的原始方法
            Object[]:原始方法的所有参数，也就是method对应的参数
            Object：代表原始对象（method对应的原始对象）
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before:执行方法："+method+"，"+method.getName());
    }

}
