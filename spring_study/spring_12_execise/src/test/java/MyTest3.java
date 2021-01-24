import com.zph.demo3.Proxy;
import com.zph.demo3.Service;
import com.zph.demo3.ServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest3 {

    @Test
    public void test1(){
        Proxy proxy=new Proxy();
        Service service=new ServiceImpl();
        proxy.setTarget(service);
        Service proxy1 = (Service) proxy.getProxy();
        proxy1.delete();
    }


    //测试AOP实现方式一
    @Test
    public void test2(){
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext01.xml");
        Service service = context.getBean("serviceImpl",Service.class);
        service.add();
    }


    //测试AOP实现方式二（推荐使用的方式）
    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext02.xml");
        Service serviceImpl = context.getBean("serviceImpl", Service.class);
        serviceImpl.add();
    }
}
