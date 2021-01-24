import jdk.nashorn.internal.scripts.JD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestTransaction {
    public static void main(String[] args) throws Exception {

        //获取连接
      /*  Connection connection = JDBCUtils.getConnection();


        String sql1 = "update student set score = score+1 where stu_name=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        preparedStatement.setString(1, "zhaoxiaoliu");
        preparedStatement.executeUpdate();


        preparedStatement.setString(1, "wangwu");
        preparedStatement.executeUpdate();
        JDBCUtils.close(null, null, connection);*/
        testBatch();


    }

    public static void test() throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection.setAutoCommit(false);//相当于开启事务
        try {
            connection = JDBCUtils.getConnection();
            String sql1 = "update student set score = score+1 where stu_name=?";
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setString(1, "zhaoxiaoliu");
            preparedStatement.executeUpdate();
            preparedStatement.setString(1, "wangwu");
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    public static void testBatch() throws Exception{
        Connection connection = JDBCUtils.getConnection();
        String sql="insert into  user values (null,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        for(int i=0;i<5000;++i){
            preparedStatement.setString(1,"john"+i);
            preparedStatement.setString(2,"123");
            preparedStatement.setString(3,"john"+i+"@163.com");
            preparedStatement.addBatch();

            if(i%1000==0){
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }
        JDBCUtils.close(null,preparedStatement,connection);

    }
}
