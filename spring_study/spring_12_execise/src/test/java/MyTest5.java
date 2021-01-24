import com.zph.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest5 {
    //测试事务的代码
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext04.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        userMapper.textTX();

    }
}
