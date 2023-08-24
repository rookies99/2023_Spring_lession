package com.baizhi;


import com.baizhi.proxy.User;
import com.baizhi.proxy.a.UserService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerformanceMonitor {

    /**
     * 用于测试性能监控
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.register(new User("suns","123456"));
        userService.login("suns", "123456");
    }
}
