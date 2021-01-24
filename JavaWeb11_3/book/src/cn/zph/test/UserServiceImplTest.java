package cn.zph.test;

import cn.zph.pojo.User;
import cn.zph.service.UserService;
import cn.zph.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceImplTest {
    UserService userService=new UserServiceImpl();
    @Test
    public void login() {
        User user=new User(null,"admin","admin","admin@google.com");
        if(userService.login(user)==null){
            System.out.println("用户登录失败");
        }else {
            System.out.println("用户登录成功");
        }
    }

    @Test
    public void registUser() {
        User user=new User(null,"小明","admin","admin@google.com");
        if(!userService.existsUsername(user.getUsername())){
             userService.registUser(user);
            System.out.println("注册成功");
        }else{
            System.out.println("用户名已存在，注册失败！");
        }
    }

    @Test
    public void existsUsername() {
        if(!userService.existsUsername("admin")){
            System.out.println("用户名不存在");
        }else{
            System.out.println("用户名已存在");
        }
    }
}