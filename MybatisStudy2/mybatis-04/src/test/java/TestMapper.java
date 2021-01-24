import com.zph.dao.UserMapper;
import com.zph.pojo.User;
import com.zph.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMapper {


    @Test
    public void test1(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = mapper.getAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
        sqlSession.close();
        //sqlSession.clearCache();//手动清理缓存
        //System.out.println("=============================================");
        /*SqlSession sqlSession2=MybatisUtils.getSqlSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        List<User> allUser2 = mapper2.getAllUser();
        for (User user : allUser2) {
            System.out.println(user);
        }
        sqlSession2.close();*/
    }
}
