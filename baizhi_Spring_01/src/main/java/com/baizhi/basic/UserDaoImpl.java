package com.baizhi.basic;

public class UserDaoImpl implements UserDao{

    @Override
    public void save(User user) {
        System.out.println("user = " + user);
    }

    @Override
    public void queryUserByNameAndPassword(String name, String password) {
        System.out.println("name = " + name+",password = " + password);
    }
}
