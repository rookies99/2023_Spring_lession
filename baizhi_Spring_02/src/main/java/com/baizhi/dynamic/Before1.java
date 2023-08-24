package com.baizhi.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Before1 implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before1:执行方法："+method+"，"+method.getName());
    }
}
