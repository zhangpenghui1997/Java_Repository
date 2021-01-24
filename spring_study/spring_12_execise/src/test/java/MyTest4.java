import com.zph.bean.User;
import com.zph.mapper.UserMapper;
import com.zph.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest4 {
    //测试Mybatis

    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }

    }


    //Spring整合Mybatis
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext03.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        List<User> users = userMapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test3(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext03.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        User user=new User(10,"杜牧","fc123");
        int i = userMapper.addUser(user);
        if(i>0){
            System.out.println("插入成功");
        }
    }

    @Test
    public void test4(){
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext03.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        int i = userMapper.deleteUser(10);
        if(i>0){
            System.out.println("删除成功");
        }

    }
}
