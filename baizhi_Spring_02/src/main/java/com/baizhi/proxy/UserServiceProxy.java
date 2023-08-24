package com.baizhi.proxy;

import com.baizhi.proxy.a.UserService;
import com.baizhi.proxy.a.UserServiceImpl;

public class UserServiceProxy implements UserService {
    private UserServiceImpl userService = new UserServiceImpl();
    @Override
    public void register(User user) {
        System.out.println("-----log-----");
        userService.register(user);
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("-----log-----");

        return userService.login(name,password);
    }


}
