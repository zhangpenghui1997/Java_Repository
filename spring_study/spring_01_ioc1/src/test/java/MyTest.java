import com.zph.dao.UserDaoMysqlImpl;
import com.zph.dao.UserDaoOracleImpl;
import com.zph.service.Service;
import com.zph.service.ServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
        Service service = context.getBean("serviceImpl",Service.class);
        service.getUser();
    }
}
