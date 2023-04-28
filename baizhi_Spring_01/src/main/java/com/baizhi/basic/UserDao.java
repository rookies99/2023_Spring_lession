package com.baizhi.basic;

public interface UserDao {
    void save(User user);

    void queryUserByNameAndPassword(String name, String password);
}
