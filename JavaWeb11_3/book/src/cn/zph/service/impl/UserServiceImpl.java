package cn.zph.service.impl;

import cn.zph.dao.UserDao;
import cn.zph.pojo.User;
import cn.zph.dao.impl.UserDaoImpl;
import cn.zph.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao =new UserDaoImpl();
    @Override
    public User login(User user) {
        return userDao.queryByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.queryByUsername(username)==null){
            return false;
        }else{
            return true;
        }
    }
}
