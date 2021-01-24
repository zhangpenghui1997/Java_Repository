package cn.zph.eshop.user.service.impl;

import cn.zph.eshop.user.dao.UserDAO;
import cn.zph.eshop.user.dao.impl.UserDAOImpl;
import cn.zph.eshop.user.entity.User;
import cn.zph.eshop.user.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public User login(User user) throws Exception {
        UserDAO dao = new UserDAOImpl();
        List<User> userList = dao.getEntityList();
        if (userList != null) {
            for (User user1 : userList) {
                if (user1.getUsername().equals(user.getUsername()) && user1.getPassword().equals(user.getPassword())) {
                    return user1;//匹配成功返回用户对象
                }
            }
        }

        return null;//失败返回null
    }
}
