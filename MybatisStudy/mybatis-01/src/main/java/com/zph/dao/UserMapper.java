package com.zph.dao;

import com.zph.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //得到所有用户
    List<User> getUserList();
    //根据用户id获取用户对象
    User getUserById(int id);

    //查询用户
    User getUserById2(Map<String,Object> map);
    //模糊查询
    List<User> getUserByLike(String value);
    //添加用户
    int addUser(User user);

    //万能的map
    int addUserByMap(Map<String, Object> map);

    //修改用户
    int updateUsernameById(@Param("id") int id,@Param("name") String name);

    //删除用户
    int deleteUserById(@Param("id") int id);

    @Select("select * from user")
    List<User> getUsers();


    @Update("update user set name=#{name} where id=#{id}")
    int updateUser(@Param("id") int id, @Param("name") String name);

    @Insert("insert into user value(#{id},#{name},#{pwd})")
    int insertUserToTable(User user);
}
