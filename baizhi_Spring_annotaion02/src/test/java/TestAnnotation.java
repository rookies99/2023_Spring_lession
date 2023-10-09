import com.baizhi.AppConfig;
import com.baizhi.bean.User;
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

}
