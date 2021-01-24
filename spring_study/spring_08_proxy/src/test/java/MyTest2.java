import com.zph.demo2.UserServiceImplProxy;
import org.junit.Test;

public class MyTest2 {
    @Test
    public void test1(){
        UserServiceImplProxy userServiceImplProxy =new UserServiceImplProxy();
        userServiceImplProxy.add();
    }
}
