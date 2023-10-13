package com.baizhi;

import com.baizhi.bean.Customer;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;


@Configuration
@ComponentScan(basePackages = "com.baizhi.bean")
@ImportResource("applicationContext.xml")// 与spring配置文件集成，先读取配置@Bean 在读取配置文件
public class AppConfig3 {

    @Bean
    public Customer customer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("suns");
        return customer;
    }
}
