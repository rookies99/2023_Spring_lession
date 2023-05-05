package com.baizhi.proxy;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public void register(User user) {

        System.out.println("UserServiceImpl.register 注册成功");
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
