import com.zph.demo1.Host;
import com.zph.demo1.Proxy;
import org.junit.Test;

public class MyTest {
    @Test
    public void test1(){
        Host host = new Host();
        host.rent();
    }

    @Test
    public void test2(){
        Host host = new Host();
        Proxy proxy = new Proxy(host);
        proxy.introduceHouse();
        proxy.rent();
        proxy.contract();
        proxy.fare();
    }

}
