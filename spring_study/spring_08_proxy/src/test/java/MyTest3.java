import com.zph.demo3.Host;
import com.zph.demo3.HostMaster;
import com.zph.demo3.ProxyInvocationHandler;
import org.junit.Test;

public class MyTest3 {
    @Test
    public void test1(){
        HostMaster hostMaster=new HostMaster();
        ProxyInvocationHandler proxyInvocationHandler =new ProxyInvocationHandler();
        proxyInvocationHandler.setHostMaster(hostMaster);
        Host proxy = (Host) proxyInvocationHandler.getProxy();
        proxy.rent();
    }
}
