package com.baizhi;

import com.baizhi.basic.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    /**
     * 用于测试:Spring的第一个程序
     */
    @Test
    public void test3() {
        //1.获取Spring的工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        //2 通过工厂类获取对象
        Person person = (Person) context.getBean("person");
        System.out.println("person = " + person);
    }
}
