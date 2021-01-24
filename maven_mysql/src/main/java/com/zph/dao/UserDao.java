package com.zph.dao;

import com.zph.bean.User;

import java.util.List;

public interface UserDao {
     List<User> getAllUsers() throws Exception;
}
