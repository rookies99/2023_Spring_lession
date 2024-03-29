import com.baizhi.bean.User;
import com.baizhi.injection.Category;
import com.baizhi.injection.UserService;
import com.baizhi.lazy.Account;
import com.baizhi.life.Product;
import com.baizhi.scope.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {


    /*
        用于测试@Component注解
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) ctx.getBean("u");
        System.out.println("id:"+user.getId());
    }

    /*
        用于测试@Scope注解
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Customer customer = (Customer) ctx.getBean("customer");
        Customer customer1 = (Customer) ctx.getBean("customer");
        System.out.println("customer = " + customer);
        System.out.println("customer1 = " + customer1);
    }

    /*
        用于测试@Lazy注解
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Account account = (Account) ctx.getBean("account");

    }

    /*
        用于测试生命周期相关注解
     */
    @Test
    public void test4() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ctx.close();
    }

    /*
        用于测试@Autowired注解
     */
    @Test
    public void test5() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServiceImpl = (UserService) ctx.getBean("userServiceImpl");
        userServiceImpl.register();
    }

    /*
        用于测试@Value注解
     */
    @Test
    public void test6() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Category category = (Category) ctx.getBean("category");
        System.out.println("category.getName() = " + category.getName());
        System.out.println("category.getId() = " + category.getId());
    }
    
    /*
        用于测试排除策略
     */
    @Test
    public void test7() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] beanDefinitionNames = (String[]) ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }

}
