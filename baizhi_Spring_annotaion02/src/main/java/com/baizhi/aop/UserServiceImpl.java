package com.baizhi.aop;

import com.baizhi.injection.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void register() {
        System.out.println("UserServiceImpl.register");
    }

    @Override
    public void login() {
        System.out.println("UserServiceImpl.login");
    }
}
