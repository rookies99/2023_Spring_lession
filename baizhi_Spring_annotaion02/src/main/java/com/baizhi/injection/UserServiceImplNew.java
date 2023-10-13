package com.baizhi.injection;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImplNew implements UserDao {

    @Override
    public void save() {
        System.out.println("UserServiceImplNew.save");
    }
}
