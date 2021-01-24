package com.zph.service;

import com.zph.dao.UserDao;
import com.zph.dao.UserDaoImpl;
import com.zph.dao.UserDaoMysqlImpl;
import com.zph.dao.UserDaoOracleImpl;
import org.springframework.beans.factory.annotation.Value;

public class ServiceImpl implements Service {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getAllUser();
    }
}
