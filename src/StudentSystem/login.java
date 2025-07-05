package StudentSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 用于学生信息管理系统的登录功能
public class login {

    // login登录功能
    public void login() throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.println("学生信息管理系统");
        System.out.println();
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();

    //  调用login_check登录验证方法，进行登录验证
        if (login_check(username,password)){
                System.out.println("登录成功！");
        }else {
            System.out.println("用户名或密码错误");
        }

    }
    public boolean login_check(String username,String password) throws SQLException {
        // 创建DatabaseTest对象以获取数据库连接
        DatabaseTest d1 = new DatabaseTest();
        // 创建Connection对象,用于获取数据库连接
        Connection connection = d1.getConnection();
        //  创建Statement对象,用于执行SQL语句
        Statement statement = connection.createStatement();
        // 构造SQL查询语句,用于在表中查找匹配的用户名和密码
        String sql = "select * from login_admin where username = '"+username+"' and password = '"+password+"'";
        ResultSet res= statement.executeQuery(sql);

        //检查查询结果是否为空
        if (!res.next()){
            return false;
        }else {
            return true;
        }
    }
}





