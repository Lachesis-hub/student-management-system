package StudentSystem;

import java.sql.SQLException;

// 主测试类
public class TestMain {
    public static void main(String[] args) throws SQLException {

        // 测试登录功能
        login login  = new login();
        login.login();

        // 测试查询功能
        WindowTest WindowTest = new WindowTest();
    }
}