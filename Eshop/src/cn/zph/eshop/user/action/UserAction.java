package cn.zph.eshop.user.action;

import cn.zph.eshop.common.action.BaseAction;
import cn.zph.eshop.common.entity.Msg;
import cn.zph.eshop.log.ISysLog;
import cn.zph.eshop.log.impl.ConsoleLog;
import cn.zph.eshop.user.entity.User;
import cn.zph.eshop.user.service.UserService;
import cn.zph.eshop.user.service.impl.UserServiceImpl;

import static cn.zph.eshop.common.util.JSONUtil.Entity2JSON;
/*用户控制器类
 * 处理用户的后台操作，并返回JSON字符串消息
 * */

public class UserAction extends BaseAction {
    //用户名
    private String username;
    //密码
    private String password;

    public String login() throws Exception {
        Msg msg = new Msg();
        //1.封装user对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //2.调用UserService处理业务逻辑
        UserService userService = new UserServiceImpl();
        user = userService.login(user);
        //根据返回结果,生成消息
        if (user != null) {
            msg.setType(Msg.getSUCCESS());
            msg.setMsg("登录成功");
            log.info(username + "已经登录！");
            return Entity2JSON(msg);
        } else {
            msg.setType(Msg.getFAIL());
            msg.setMsg("登录失败");
            return Entity2JSON(msg);
        }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
