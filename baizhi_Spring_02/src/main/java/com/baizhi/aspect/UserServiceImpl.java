package com.baizhi.aspect;

import com.baizhi.Log;
import com.baizhi.proxy.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, ApplicationContextAware {
    private ApplicationContext ctx;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    @Log
    @Override
    public void register(User user) {

        System.out.println("UserServiceImpl.register 注册成功");
//        throw new RuntimeException("测试异常");
        /*
            调用的是原始对象的login方法 ---》核心功能，没有额外功能
            设计目的：代理对象的login方法 ---》 额外功能+核心功能
            所以应该调取代理对象的login方法，要获得工厂，而工厂通过ApplicationContextAware获得
         */
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("suns", "123456");
    }

    @Override
    public boolean login(String name, String password) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("UserServiceImpl.login登录成功");
        return true;
    }


}
