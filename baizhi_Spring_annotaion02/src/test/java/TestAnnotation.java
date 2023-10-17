import com.baizhi.*;
import com.baizhi.bean.Customer;
import com.baizhi.bean.User;
import com.baizhi.four.Account;
import com.baizhi.four.AppConfig10;
import com.baizhi.injection.UserDao;
import com.baizhi.injection.UserDaoImpl;
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

    /**
     * 用于测试:多配置Bean的整合
     */
    @Test
    public void test9() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.baizhi.config");
        UserDao userDAO = (UserDao) ctx.getBean("userDAO");
        UserService userService = (UserService) ctx.getBean("userService");
        System.out.println("userService = " + userService);
        System.out.println("userDAO = " + userDAO);
    }

    /**
     * 用于测试:多配置Bean的整合 @Import
     */
    @Test
    public void test10() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(com.baizhi.config.AppConfig1.class);
        UserDao userDAO = (UserDao) ctx.getBean("userDAO");
        UserService userService = (UserService) ctx.getBean("userService");
        System.out.println("userService = " + userService);
        System.out.println("userDAO = " + userDAO);
    }

    /**
     * 用于测试:@Component与配置Bean的整合
     */
    @Test
    public void test11() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(com.baizhi.config.AppConfig3.class);
        UserService userService = (UserService) ctx.getBean("userService");
//        UserDao userDAOImpl = (UserDao) ctx.getBean("userDaoImpl");
//        System.out.println("userDAOImpl = " + userDAOImpl);
//        System.out.println("userService = " + userService);
        userService.register();
    }

    /**
     * 用于测试:@Component与配置Bean的整合
     */
    @Test
    public void test12() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(com.baizhi.config.AppConfig4.class);
        UserService userService = (UserService) ctx.getBean("userService");
//        UserDao userDAOImpl = (UserDao) ctx.getBean("userDAO");
//        System.out.println("userDAOImpl = " + userDAOImpl);
//        System.out.println("userService = " + userService);
        userService.register();
    }

    /**
     * 用于测试:@Bean底层实现原理
     */
    @Test
    public void test13() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User u = (User) ctx.getBean("u");
    }

    /**
     * 用于测试:四维一体开发
     */
    @Test
    public void test14() {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig10.class);
        Account account = (Account) ctx.getBean("account");
        System.out.println("account.getName() = " + account.getName());
        System.out.println("account.getId() = " + account.getId());
    }

}
