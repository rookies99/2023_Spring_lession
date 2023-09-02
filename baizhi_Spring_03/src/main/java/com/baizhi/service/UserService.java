package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
    void register(User user) throws Exception;
    void login(String name,String password);
}
