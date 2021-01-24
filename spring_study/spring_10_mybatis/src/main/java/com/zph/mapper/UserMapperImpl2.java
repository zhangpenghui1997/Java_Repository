package com.zph.mapper;

import com.zph.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper{
    public List<User> getUsers() {
        return getSqlSession().getMapper(UserMapper.class).getUsers();
    }
}
