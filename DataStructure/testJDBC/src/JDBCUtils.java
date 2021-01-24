import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
  private static String username;
  private static String password;
  private static String url;
  private static String driver;

    static {
        try {
        Properties info = new Properties();
        info.load(new FileInputStream("testJDBC/src/jdbc.properties"));
         username = info.getProperty("user");
         password = info.getProperty("password");
         url = info.getProperty("url");
         driver = info.getProperty("driver");
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws Exception {


        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) throws Exception {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }

    }
}
