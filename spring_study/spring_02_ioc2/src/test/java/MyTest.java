import com.zph.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test1() {
        //获得Ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //获得bean
        User user = context.getBean("MyUser",User.class);
        user.show();

    }
}
