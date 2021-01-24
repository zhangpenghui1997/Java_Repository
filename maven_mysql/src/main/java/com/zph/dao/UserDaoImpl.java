package com.zph.dao;

import com.zph.bean.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao  {
    public List<User> getAllUsers() throws Exception{
        List<User> list = new ArrayList<User>();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql:///mybatis","root","123123");
            preparedStatement = connection.prepareCall("select * from user");
            resultSet=preparedStatement.executeQuery();

            while(resultSet.next()){
                User user= new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setPwd(resultSet.getString(3));
                list.add(user);
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            connection.close();
            resultSet.close();
            preparedStatement.close();
        }
        return list;
    }
}
