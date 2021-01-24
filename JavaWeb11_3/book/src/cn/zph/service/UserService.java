package cn.zph.service;

import cn.zph.pojo.User;

public interface UserService {
    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 注册
     * @param user
     */
    public void registUser(User user);

    /**
     * 判断用户名是否已存在
     * @param username
     * @return  true代表用户名已存在，false代表用户名不存在可用
     */
    public boolean existsUsername(String username);
}
