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

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(3, "小米", "1234897");
        int i = mapper.addUser(user);
        if (i > 0) {
            System.out.println("插入成功！");
        }
        //增删改均需要提交事务
        //sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void test4() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.updateUsernameById(3, "小红");
        if (i > 0) {
            System.out.println("修改成功！");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void test5() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.deleteUserById(3);
        if (i > 0) {
            System.out.println("删除成功！");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test6() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", 6);
        map.put("userName", "多多");
        map.put("passWord", "1232qwer");
        int i = mapper.addUserByMap(map);
        if (i > 0) {
            System.out.println("添加成功！");
        }
        sqlSession.commit();
        sqlSession.close();


    }

    @Test
    public void test7() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 1);
        map.put("name", "张三");

        User userById2 = mapper.getUserById2(map);
        System.out.println(userById2);
        sqlSession.close();
    }

    @Test
    public void test8() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserByLike("李");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();


    }

    @Test
    public void test9(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void test10(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int r=mapper.updateUser(3, "小红");
       if(r>0){
           System.out.println("更新成功！");
       }

        sqlSession.close();
    }

    @Test
    public void test11(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=new User(4,"赵六","abcqwerty");
        int r=mapper.insertUserToTable(user);
        if(r>0){
            System.out.println("插入成功！");
        }

        sqlSession.close();
    }
}
