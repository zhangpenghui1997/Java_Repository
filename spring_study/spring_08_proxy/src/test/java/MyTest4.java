
import com.zph.demo4.ProxyInvocationHandler;
import com.zph.demo4.Service;
import com.zph.demo4.ServiceImpl;
import org.junit.Test;

public class MyTest4 {
    @Test
    public void test1(){
        ServiceImpl service=new ServiceImpl();
        ProxyInvocationHandler proxyInvocationHandler =new ProxyInvocationHandler();
        proxyInvocationHandler.setTarget(service);
        Service proxy = (Service) proxyInvocationHandler.getProxy();
        proxy.delete();
    }
}
