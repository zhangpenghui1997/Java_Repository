package cn.zph.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 获取数据库连接对象
 */
public class JdbcUtils {
private static ThreadLocal<Connection> threadLocal=new ThreadLocal<Connection>();
    private static DruidDataSource druidDataSource;
    static {
        try {
            //读取jdbc.properties属性文件
            Properties properties=new Properties();
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            //创建数据库连接池
            druidDataSource= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //返回null代表连接失败
    //有值就是成功
    public static Connection getConnection(){
        Connection connection=threadLocal.get();
      /*  try{
            connection=druidDataSource.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }*/
      if(connection==null){
          try{
              connection=druidDataSource.getConnection();
              threadLocal.set(connection);//连接对象保存到threadLocal中
              connection.setAutoCommit(false);//设置为手动提交事务
          }catch (Exception e){

              e.printStackTrace();
          }
      }

        return connection;
    }

    /**
     * 提交事务，关闭连接
     */
    public static void commitAndClose(){
        Connection connection=threadLocal.get();
        if(connection!=null){
            //说明连接使用过
            try {
                //提交事务并关闭连接
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        threadLocal.remove();
    }

    /**
     * 回滚事务关闭连接
     */
    public static void rollbackAndClose(){
        Connection connection=threadLocal.get();
        if(connection!=null){
            //说明连接使用过
            try {
                //回滚事务并关闭连接
                connection.rollback();

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行remove操作，否则就会出错，tomcat服务器底层使用了线程池技术
        threadLocal.remove();
    }

    /**
     * 关闭连接,放回数据库连接池
     */
    public static void close(Connection conn){
       if(conn!=null){
           try {
               conn.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
    }


}
