import com.baizhi.*;
import com.baizhi.bean.Customer;
import com.baizhi.bean.User;
import com.baizhi.injection.UserDao;
import com.baizhi.injection.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

public class TestAnnotation {

    /**
     * 用于测试 配置Bean注解
     */
    @Test
    public void test1() {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.baizhi");
    }

    /**
     * 用于测试 配置Bean注解
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//        User user = (User) ctx.getBean("user");
//        System.out.println("user = " + user);
//        Connection conn = (Connection) ctx.getBean("conn");
//        System.out.println("conn = " + conn);

        Connection conn1 = (Connection) ctx.getBean("conn1");
        System.out.println("conn1 = " + conn1);
    }

    /**
     * 用于测试 对象的创建次数
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User u = (User) ctx.getBean("u");
        User u1 = (User) ctx.getBean("u");
        System.out.println("u = " + u);
        System.out.println("u1 = " + u1);
    }

    /**
     * 用于测试 @Bean注解注入
     */
    @Test
    public void test4() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
        UserService userService = (UserService) ctx.getBean("userService");
        userService.register();
    }

    /**
     * 用于测试 @JDK类型注入
     */
    @Test
    public void test5() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println("customer.getId() = " + customer.getId());
        System.out.println("customer.getName() = " + customer.getName());
    }

    /**
     * 用于测试@ComponentScan 基本使用
     */
    @Test
    public void test6() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig2.class);
        String[] beanDefinitionNames = (String[]) ctx.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanDefinitionName = beanDefinitionNames[i];
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }

    /**
     * 用于测试配置的覆盖
     */
    @Test
    public void test7() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig3.class);
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println("customer.getId() = " + customer.getId());
        System.out.println("customer.getName() = " + customer.getName());
    }
    
    /**
     * 用于测试:解耦合
     */
    @Test
    public void test8() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig4.class,AppConfig5.class);
        ApplicationContext ctx1 = new AnnotationConfigApplicationContext("com.baizhi");
        UserDao userDao = (UserDao) ctx.getBean("userDAO");
        userDao.save();
    }

}
