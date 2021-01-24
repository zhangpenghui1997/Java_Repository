package com.zph.dao;

import com.zph.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //得到所有用户
    List<User> getUserList();
    //根据用户id获取用户对象
    User getUserById(int id);

    List<User> getUserByLimit(Map<String,Integer> map);

    List<User> getUserByRowBounds();


}
