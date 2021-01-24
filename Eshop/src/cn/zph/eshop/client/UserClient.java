package cn.zph.eshop.client;

import cn.zph.eshop.common.entity.Msg;
import cn.zph.eshop.common.util.JSONUtil;
import cn.zph.eshop.user.action.UserAction;

import java.util.Scanner;

public class UserClient extends Client {
    public String showLogin() throws Exception {
        //1.使用控制台提示用户输入用户名、密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        UserAction userAction = new UserAction();
        //2.向服务器发送请求并接受返回消息字符串
        userAction.setUsername(username);
        userAction.setPassword(password);
        //调用Action登录功能
        String result = userAction.login();

        //3.解析消息字符串，提示用户信息
        Msg msg =(Msg)JSONUtil.JSON2Entity(result, Msg.class);
        if(msg.getType().equals(Msg.SUCCESS)){
            //登录成功
            System.out.println(msg.getMsg());
            return HISTORY;

        }else {
            System.out.println(msg.getMsg());
            return LOGIN;
        }


    }
}
