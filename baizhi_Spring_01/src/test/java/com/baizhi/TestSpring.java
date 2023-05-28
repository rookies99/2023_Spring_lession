package com.baizhi;

import com.baizhi.basic.*;
import com.baizhi.basic.constructer.Customer;
import com.baizhi.factorybean.ConnectionFactoryBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestSpring {
    /**
     * 用于测试工厂类进行解耦合的操作
     */
    @Test
    public void test1(){
//        UserService userService = new UserServiceImpl();
        UserService userService = (UserService) BeanFactory.getBean("userService");

        userService.login("name", "suns");

        User user = new User("suns", "123456");
        userService.register(user);
    }


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

    /**
     * 用于测试：Spring工厂提供的其他方法
     */
    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
//        Person person = context.getBean("person", Person.class);
//        System.out.println("person = " + person);

        //当前Spring的配置文件中只能有一个<bean cass是Person类型
//        Person person = context.getBean(Person.class);
//        System.out.println("person = " + person);

        //获取的是 Spring工厂配置文件中所有bean标签的id值 person person1...
       /* String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }*/

        //根据类型获取Spring配置文件中对应的id值
       /* String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }*/
        //用于判断是否存在指定id值的bean，不能判断name值
//        System.out.println(context.containsBeanDefinition("p"));

        //用于判断是否存在指定id值以及name值的bean
        System.out.println(context.containsBean("p"));
    }

    /**
     * 用于测试：Spring的配置文件
     */
    @Test
    public void test5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = context.getBean(Person.class);
        System.out.println("person = " + person);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    /**
     * 用于测试name属性
     */
    @Test
    public void test6() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) context.getBean("person");
        System.out.println("person = " + person);
    }

    /**
     * 用于测试注入
     */
    @Test
    public void test7() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) context.getBean("person");
        person.setId(1);
        person.setName("suns");
        System.out.println("person = " + person);
    }

    /**
     * 通过Spring的配置文件进行赋值（注入）
     */
    @Test
    public void test8() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) context.getBean("person");
        System.out.println("person = " + person);
    }

    /**
     * 用于测试JDK类型成员变量的赋值
     */
    @Test

    public void test9() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) context.getBean("person");
        String[] email = person.getEmails();
        for (String s : email) {
            System.out.println(s);
        }
        System.out.println("----------------------------");
        Set<String> tels = person.getTels();
        for (String tel : tels) {
            System.out.println("tel = " + tel);
        }
        System.out.println("---------------------------");
        List<String> addresses = person.getAddress();
        for (String address : addresses) {
            System.out.println("address = " + address);
        }
        System.out.println("---------------------------");
        Map<String, String> qqs = person.getQqs();
        for (Map.Entry<String, String> entry : qqs.entrySet()) {
            System.out.println("key = " + entry.getKey());
            System.out.println("value = " + entry.getValue());
        }
        System.out.println("---------------------------");
        Properties p = person.getP();
        System.out.println("key1 +value is  = " + p.getProperty("key1"));
        System.out.println("key2 +value is  = " + p.getProperty("key2"));
    }

    /**
     * 用于测试用户自定义类型成员变量的赋值
     */
    @Test
    public void test10() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.register(new User("suns", "123456"));
        userService.login("xiaohei","123456");
    }

    /**
     * 用于测试构造注入
     */
    @Test
    public void test11() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println("customer = " + customer);
    }

    /**
     * 用于测试FactoryBean接口
     */
    @Test
    public void test12() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Connection connection = (Connection) ctx.getBean("conn");
        Connection conn2 = (Connection) ctx.getBean("conn");
        System.out.println("connection = " + connection);
        System.out.println("conn2 = " + conn2);
    }

    /**
     * 用于测试FactoryBean接口
     */
    @Test
    public void test13() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConnectionFactoryBean conn = (ConnectionFactoryBean) ctx.getBean("&conn");
        System.out.println("conn = " + conn);
    }
}
