import com.zph.diy.DiyPointCut;
import com.zph.service.Service;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest1 {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Service service = (Service) context.getBean("serviceImpl");
        service.add();
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext02.xml");
        Service service = (Service) context.getBean("serviceImpl");
        service.select();
    }

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext03.xml");
        Service service = (Service) context.getBean("serviceImpl");
        service.select();
    }
}
