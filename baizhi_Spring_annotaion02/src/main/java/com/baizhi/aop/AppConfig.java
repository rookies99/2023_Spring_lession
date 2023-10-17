package com.baizhi.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.baizhi.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
