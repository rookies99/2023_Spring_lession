package com.baizhi;

import com.baizhi.bean.Customer;
import com.baizhi.bean.User;
import com.baizhi.injection.UserDao;
import com.baizhi.injection.UserDaoImpl;
import com.baizhi.injection.UserService;
import com.baizhi.injection.UserServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;


@Configuration
//@ComponentScan(basePackages = "com.baizhi.scan",
//        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Service.class})
//                            ,@ComponentScan.Filter(type = FilterType.ASPECTJ,pattern = "*..User1")})
@ComponentScan(basePackages = "com.baizhi.scan",
        useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class})})
public class AppConfig2 {


}
