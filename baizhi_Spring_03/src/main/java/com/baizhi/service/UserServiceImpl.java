package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Transactional(rollbackFor = {Exception.class},noRollbackFor = {RuntimeException.class})
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register(User user) throws Exception{
        userDao.save(user);
//        throw new RuntimeException("测试");
//        throw new Exception("测试2");
    }

    @Override
//    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public void login(String name, String password) {

    }
}
