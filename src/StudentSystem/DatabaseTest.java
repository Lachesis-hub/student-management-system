package StudentSystem;

import java.sql.Connection;
import java.sql.DriverManager;

//  数据库连接测试类
public class DatabaseTest {

    public Connection  getConnection() {
        // 定义数据库连接URL,包括数据库服务器地址,端口,数据库名,时区设置和SSL设置
        String url = "jdbc:mysql://localhost:3306/systemdb?serverTimezone=GMT%2B8&useSSL=false";
        String name = "root"; // 定义数据库名
        String password = "123456"; // 密码
        Connection connection = null;
        try {
            // 加载并注册JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 使用DriverManager获取数据库连接
            connection = DriverManager.getConnection(url, name, password);
        } catch (Exception e) {
            // 打印异常信息,用于调试
            e.printStackTrace();
        }
        return connection;
    }
}
