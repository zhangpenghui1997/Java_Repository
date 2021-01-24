
import com.zph.demo2.Host;
import com.zph.demo2.HostMaster;
import com.zph.demo2.ProxyInvocationHandler;
import org.junit.Test;

public class MyTest2 {

    @Test
    public void test5(){
        ProxyInvocationHandler proxyInvocationHandler=new ProxyInvocationHandler();
        HostMaster hostMaster=new HostMaster();
        proxyInvocationHandler.setHostMaster(hostMaster);
        Host host = (Host) proxyInvocationHandler.getProxy();
        host.rent();

    }
}
