package com.baizhi.proxy;

public interface UserService {
    void register(User user);

    boolean login(String name, String password);
}
