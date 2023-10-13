package com.baizhi;

import com.baizhi.bean.Customer;
import com.baizhi.injection.UserDao;
import com.baizhi.injection.UserDaoImpl;
import com.baizhi.injection.UserService;
import com.baizhi.injection.UserServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:/init.properties")
public class AppConfig1 {

    @Value("${id}")
    private Integer id;
    @Value("${name}")
    private String name;

    @Bean
    public UserDao userDAO(){
        return new UserDaoImpl();
    }

    @Bean
    public UserService userService(){
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDAO());
        return userService;
    }

    @Bean
    public Customer customer(){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        return customer;
    }
}
