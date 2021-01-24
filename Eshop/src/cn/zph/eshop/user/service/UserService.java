package cn.zph.eshop.user.service;

import cn.zph.eshop.user.entity.User;

public interface UserService {
    User login(User user)throws Exception;
}
