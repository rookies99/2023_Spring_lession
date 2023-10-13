package com.baizhi;

import com.baizhi.bean.Customer;
import com.baizhi.injection.UserDao;
import com.baizhi.injection.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
public class AppConfig4 {

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl();
    }
}
