package com.baizhi.proxy.a;

import com.baizhi.proxy.User;

public interface UserService {
    void register(User user);

    boolean login(String name, String password);

}
