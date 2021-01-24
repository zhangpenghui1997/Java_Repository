package com.zph.test;

import com.zph.bean.User;
import com.zph.dao.UserDao;
import com.zph.dao.UserDaoImpl;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
  @Test
    public void test1() throws Exception {
      UserDao userDao=new UserDaoImpl();
      List<User> allUsers = userDao.getAllUsers();
      for (User allUser : allUsers) {
          System.out.println(allUser);
      }
  }
}
