package cn.zph.test;

import cn.zph.dao.UserDao;
import cn.zph.dao.impl.UserDaoImpl;
import cn.zph.pojo.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void queryByUsername() {
        UserDao userDao=new UserDaoImpl();
        if(userDao.queryByUsername("admin")==null){
            System.out.println("用户名不可用");
        }else{
            System.out.println("用户名可用");
        }
    }

    @Test
    public void saveUser() {
        UserDao userDao=new UserDaoImpl();
        User user=new User(null,"Jony","123456","123456@qq.com");
        if(userDao.saveUser(user)==1){
            System.out.println("插入数据成功");
        }else{
            System.out.println("插入数据失败");
        }
    }

    @Test
    public void queryByUsernameAndPassword() {
        UserDao userDao=new UserDaoImpl();
        if(userDao.queryByUsernameAndPassword("Jony","123456")==null){
            System.out.println("用户不存在");
        }else{
            System.out.println("用户存在");
        }
    }
}