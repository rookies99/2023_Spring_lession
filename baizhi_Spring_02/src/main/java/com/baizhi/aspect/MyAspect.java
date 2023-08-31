package com.baizhi.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


/*
    构建切面所需的2个点
    1.额外功能
        public class MyArround implements MethodInterceptor{
            public Object invoke(MethodInvocation invocation){
                Object ret = invocation.proceed();
                return ret;
            }
        }
    2.切入点
        <aop:config
            <aop:pointcut id="" expression="execution(*login(..))"/>
 */
@Aspect
public class MyAspect {
    @Pointcut("execution(* *..UserServiceImpl.*(..))") // 复用切入点，解耦合
    public void myPointcut(){}

    @Around("myPointcut()") // 1. 切入点
    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {  // 2.额外功能 等同于 上面的 invoke
        System.out.println("-----aspect log-------");
        Object ret = joinPoint.proceed();

        return ret;
    }

    @Around("myPointcut()") // 1. 切入点
    public Object arround1(ProceedingJoinPoint joinPoint) throws Throwable {  // 2.额外功能 等同于 上面的 invoke
        System.out.println("-----aspect tx-------");
        Object ret = joinPoint.proceed();

        return ret;
    }
}
