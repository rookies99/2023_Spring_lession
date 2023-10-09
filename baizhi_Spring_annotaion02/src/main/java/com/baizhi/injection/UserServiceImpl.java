package com.baizhi.injection;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
//    @Autowired
//    @Qualifier("userDaoImpl")
    @Resource
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

//    @Autowired
//    @Qualifier("userDaoImpl")
    public void setUserDao(UserDao userDao) {
        System.out.println("UserServiceImpl.setUserDao");
        this.userDao = userDao;
    }

    @Override
    public void register() {
        userDao.save();
    }
}
