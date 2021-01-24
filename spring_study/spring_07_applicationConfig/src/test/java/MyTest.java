import com.zph.config.Config1;
import com.zph.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    @Test
    public void test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Config1.class);
        User user = context.getBean("getUser", User.class);
        System.out.println(user.getName());
    }
}
