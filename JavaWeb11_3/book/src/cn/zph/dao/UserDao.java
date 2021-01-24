package cn.zph.dao;

import cn.zph.pojo.User;

public interface UserDao {
    /**
     * 根据用户名查询用户
     * @param username  传入的用户名
     * @return
     */
    public User queryByUsername(String username);

    /**
     * 保存用户信息到数据库中
     * @param user  传入的用户bean
     * @return
     */
    public int saveUser(User user);

    /**
     * 根据用户名和密码返回查询信息
     * @param username
     * @param password
     * @return
     */
    public User queryByUsernameAndPassword(String username,String password);
}
