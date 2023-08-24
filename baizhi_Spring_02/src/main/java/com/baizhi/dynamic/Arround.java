package com.baizhi.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Arround implements MethodInterceptor {
    /*
        invoke方法的作用：把额外功能书写在invoke当中
                         额外功能就可以运行在原始方法之前、之后
        确定：原始方法怎么运行
        参数：MethodInvocation：额外功能所增加给的原始方法
        返回值：Object：原始方法的返回值
     */

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("-------log------");
        Object ret = invocation.proceed();
        return false;
    }
}
