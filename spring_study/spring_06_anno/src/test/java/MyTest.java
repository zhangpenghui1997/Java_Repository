import com.zph.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user1 = context.getBean("user",User.class);
        User user2 = context.getBean("user",User.class);
        System.out.println(user1 == user2);
    }
}
