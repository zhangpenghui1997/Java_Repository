package com.zph.mapper;

import com.zph.bean.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserMapperImpl implements UserMapper {
    private SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    /*测试事务的代码*/


    public void textTX() {
        User user =new User(10,"诸葛亮", "wl123");
        addUser(user);
        //int i= 1/0;
        deleteUser(9);
        List<User> users = getUsers();
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    public List<User> getUsers() {
        return sqlSession.getMapper(UserMapper.class).getUsers();
    }

    public int deleteUser(int id) {
        return sqlSession.getMapper(UserMapper.class).deleteUser(id);
    }

    public int addUser(User user) {
        return sqlSession.getMapper(UserMapper.class).addUser(user);
    }


}
