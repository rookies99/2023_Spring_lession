package com.baizhi.jdk;

import com.baizhi.proxy.User;
import com.baizhi.proxy.a.UserService;
import com.baizhi.proxy.a.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJDKProxy {
    public static void main(String[] args) {
        //1 创建原始对象
        UserService userService = new UserServiceImpl();

        //2 JDK创建动态代理
        /*
        参数详解：
            ClassLoader:借用类加载器，哪个都行，TestJDKProxy UserServiceImpl....
            interfaces:原始对象所实现的接口
            handler：实现invoke方法（额外方法加到原始方法中）
        注意.JDK8.x前
                创建原始对象要加 final
         */
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("-----proxy log-------");
                // 1.原始方法运行  原始对象和参数
                Object ret = method.invoke(userService, args);

                return ret;
            }
        };
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(TestJDKProxy.class.getClassLoader(), userService.getClass().getInterfaces(), handler);
        userServiceProxy.login("suns", "123456");
        userServiceProxy.register(new User());
    }
}
