package com.baizhi.factory;

import com.baizhi.proxy.User;

public interface UserService {
    public void login(String name, String password);

    void register(User user);
}
