package com.baizhi.config;

import com.baizhi.bean.Customer;
import com.baizhi.injection.UserDao;
import com.baizhi.injection.UserDaoImpl;
import com.baizhi.injection.UserService;
import com.baizhi.injection.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;


@Configuration
@Import(AppConfig2.class)
public class AppConfig1 {

    @Autowired
    private UserDao userDAO;

    @Bean
    public UserService userService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDAO);
        return userService;
    }

}
