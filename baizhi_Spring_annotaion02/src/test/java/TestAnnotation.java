import com.baizhi.AppConfig;
import com.baizhi.AppConfig1;
import com.baizhi.bean.Customer;
import com.baizhi.bean.User;
import com.baizhi.injection.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        System.out.println("customer.getName() = " + customer.getName());
        System.out.println("customer.getId() = " + customer.getId());
    }

}
