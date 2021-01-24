package com.zph.mapper;

import com.zph.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {
    public List<User> getUsers() {
        User user=new User(9,"骆宾王","bsz002");
        addUser(user);
        deleteUser(8);
        return getSqlSession().getMapper(UserMapper.class).getUsers();
    }

    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }


}
