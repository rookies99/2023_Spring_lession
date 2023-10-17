package com.baizhi.injection;

import org.springframework.stereotype.Repository;


public class UserDaoImplNew implements UserDao{
    @Override
    public void save() {
        System.out.println("UserDaoImplNew.save");
    }
}
