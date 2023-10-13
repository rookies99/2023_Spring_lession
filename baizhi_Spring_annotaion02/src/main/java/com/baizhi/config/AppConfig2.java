package com.baizhi.config;

import com.baizhi.injection.UserDao;
import com.baizhi.injection.UserDaoImpl;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;


@Configuration
public class AppConfig2 {

    @Bean
    public UserDao userDAO(){
        return new UserDaoImpl();
    }
}
