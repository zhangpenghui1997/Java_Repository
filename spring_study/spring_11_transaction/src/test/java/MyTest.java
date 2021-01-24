import com.zph.mapper.UserMapper;
import com.zph.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        List<User> users = userMapper.getUsers();
        for (User userItem : users) {
            System.out.println(userItem);
        }
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        User user =new User();
        user.setId(8);
        user.setName("王维");
        user.setPwd("mojie0568");
       if(userMapper.addUser(user)>0){
           System.out.println("插入成功！");
       }


    }

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        int i = userMapper.deleteUser(8);
        if(i>0){
            System.out.println("删除成功！");
        }
    }
}
