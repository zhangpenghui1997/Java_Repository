package com.zph.dao;

import com.zph.pojo.User;
import com.zph.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void test() {
        //获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一：getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        //方式二：
        //List<User> userList = sqlSession.selectList("com.com.zph.dao.UserMapper.getUserList");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();

    }

}
