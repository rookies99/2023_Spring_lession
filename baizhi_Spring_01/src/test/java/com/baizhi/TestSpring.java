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
}
