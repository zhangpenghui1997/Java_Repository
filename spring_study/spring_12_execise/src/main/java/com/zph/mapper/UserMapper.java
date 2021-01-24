package com.zph.mapper;

import com.zph.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> getUsers();

    int deleteUser(@Param("id") int id);

    int addUser(User user);

    void textTX();
}
