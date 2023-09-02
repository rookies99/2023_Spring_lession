import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMybatisSpring {
    /**
     * 测试Spring与Mybatis的整合
     */
    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) ctx.getBean("userDao");
        User user = new User();
        user.setName("xiaojr");
        user.setPassword("123455");
        userDao.save(user);
    }

    /**
     * 测试Spring的事务处理
     */
    @Test
    public void test2() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        User user = new User();
        user.setName("xwb3");
        user.setPassword("9898989");
        userService.register(user);
    }

    /**
     * 测试 Spring基于标签的事务处理
     */
    @Test
    public void test3() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-tx.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        User user = new User();
        user.setName("xwb5");
        user.setPassword("9898989");
        userService.register(user);
    }

}
