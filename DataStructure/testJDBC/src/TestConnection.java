import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class TestConnection {

    public static void main(String[] args) throws Exception {

        //方式一
/*
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/girls", "root", "123123");
        System.out.println("连接成功");

        //3.1
        //String sql ="delete from beauty where id=2";
        String sql = "insert into beauty values(null,'刘亦菲','女',null,'12345678900',null,null)";
        //3.2
        Statement statement = connection.createStatement();
        //3.3
        int update = statement.executeUpdate(sql);

        System.out.println(update);
        connection.close();*/


        //方式二
/*
        Class.forName("com.mysql.jdbc.Driver");   //使用方式加载

        DriverManager.getConnection("jdbc:mysql://localhost:3306/girls?user=root&password=123123");
        */


//验证登录是否正确
   /*     Properties info = new Properties();
        info.load(new FileInputStream("testJDBC/src/jdbc.properties"));
        String user = info.getProperty("user");
        String password = info.getProperty("password");
        String driver = info.getProperty("driver");
        String url = info.getProperty("url");
        Class.forName(driver);

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String username = scanner.next();
        System.out.println("请输入密码：");
        String pwd = scanner.next();

        Connection connection = DriverManager.getConnection(url, user, password);*/
        /*
        String sql = "select count(*) from user where username='" + username + "' and password='" + pwd + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            System.out.println(count > 0 ? "登录成功" : "登录失败");
        }
        */

       /* String sql = "select count(*) from user where username= ? and password =?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user);
        preparedStatement.setString(2, pwd);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            System.out.println(count > 0 ? "登录成功" : "登录失败");
        }
        connection.close();*/

        Connection connection = JDBCUtils.getConnection();

        String sql = "select * from beauty";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery(sql);
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            Date borndate = resultSet.getDate("borndate");
            String phone = resultSet.getString("phone");
            int boyfriend_id = resultSet.getInt("boyfriend_id");
            System.out.println("name:" + name + "\tsex:" + sex + "\tborndate" + borndate + "\tborndate" + borndate + "\tphone:" + phone + "\tboyfrined_id:" + boyfriend_id);
        }
       JDBCUtils.close(resultSet,preparedStatement,connection);
    }

    @Test
    public void test() throws Exception {


    }

}
