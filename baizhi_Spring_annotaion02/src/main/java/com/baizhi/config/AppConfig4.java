package com.baizhi.config;

import com.baizhi.injection.UserDao;
import com.baizhi.injection.UserService;
import com.baizhi.injection.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ImportResource("applicationContext.xml")
public class AppConfig4 {

    @Autowired
    private UserDao userDao;

    @Bean
    public UserService userService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao);
        return userService;
    }

}
