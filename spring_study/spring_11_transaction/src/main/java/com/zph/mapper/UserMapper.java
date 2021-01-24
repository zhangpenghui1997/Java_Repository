package com.zph.mapper;

import com.zph.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> getUsers();
    int addUser(User user);
    int deleteUser(@Param("id") int id);
}
