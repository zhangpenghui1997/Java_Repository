import com.zph.config.Config;
import com.zph.demo1.Host;
import com.zph.demo1.Proxy;
import com.zph.demo2.HostMaster;
import com.zph.demo2.ProxyInvocationHandler;
import com.zph.pojo.Person;
import com.zph.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void test3(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        User user = context.getBean("getUser", User.class);
        System.out.println(user);

    }

    @Test
    public void test4(){
        Proxy proxy = new Proxy();
        Host host=new Host();
        proxy.setHost(host);
        proxy.rent();
    }

}
