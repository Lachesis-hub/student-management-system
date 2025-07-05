package StudentSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 用于展示和查询学生管理系统的成绩信息
public class WindowTest {

    // 创建Scanner对象,供系统输入
    Scanner  sc = new Scanner(System.in);
    //  通过DatabaseTest类,获取数据库连接
    Connection connection = new DatabaseTest().getConnection();
    // 创建Statement对象,执行SQL语句
    Statement statement  = connection.createStatement();

    // 显示所有学生信息
    public WindowTest() throws SQLException {
        System.out.println("学生信息管理系统");
        String sql = "SELECT * from cj";
        ResultSet res = statement.executeQuery(sql);
        System.out.println("学号  |  姓名  |  语文  |  数学");
        while (res.next()){
            String xuehao = res.getString("xuehao");
            String xm = res.getString("Xm");
            String yw = res.getString("yw");
            String sx = res.getString("Sx");
            System.out.println(xuehao+"  |  "+xm+"  |  "+yw+"  |  "+sx);
        }
        menu();
    }

    // 根据学号查询成绩信息
    public void QueryXueHao(String xuehao) throws SQLException {
        // 构建SQL查询语句,用于从数据库中获取指定学号的学生信息
        String sql = "SELECT * from cj where xuehao = '"+xuehao+"'";
        // 执行SQL查询语句,获取查询结果
        ResultSet res = statement.executeQuery(sql);
        System.out.println("学号  |  姓名  |  语文  |  数学");
        // 遍历结果集,将查询到的数据打印出来
        while (res.next()){
            String xueHao = res.getString("xuehao");
            String xm = res.getString("Xm");
            int yw = res.getInt("yw");
            int sx = res.getInt("Sx");
            System.out.println(xueHao +"  |  "+xm+"  |  "+yw+"  |  "+sx);
        }

        }
    // 为用户提供操作菜单
    public void menu() throws SQLException {
        while  (true){
            System.out.println("1.查询 2.增加 3.修改 4.删除 5.退出");
            int num = sc.nextInt();
            switch (num){
                case 1:
                    query();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    System.out.println("退出系统");
                    return;
                default:
                    System.out.println("输入错误,请重新输入1-5之间的任意整数");
            }
    }

    }

    // 1.查询功能 1.1.按学号 1.2.按姓名
    public void query() throws SQLException {
        System.out.println("1.按学号查询");
        System.out.println("2.按姓名查询");
        int num = sc.nextInt();
        switch (num) {
            case 1:
                System.out.println("请输入你要查询的学号:");
                String xuehao = sc.next();
                queryXueHao(xuehao);
                break;
            case 2:
                System.out.println("请输入你要查询的姓名:");
                String name = sc.next();
                queryName(name);
                break;
            default:
        }
    }
    //1.1. 按学号查询
    public void queryXueHao(String xuehao) throws SQLException {
        String sql = "SELECT * from cj where xuehao = '"+xuehao+"'";
        ResultSet res = statement.executeQuery(sql);
        System.out.println("学号  |  姓名  |  语文  |  数学");
        while (res.next()){
            String xueHao = res.getString("xuehao");
            String xm = res.getString("Xm");
            int yw = res.getInt("yw");
            int sx = res.getInt("Sx");
            System.out.println(xueHao +"  |  "+xm+"  |  "+yw+"  |  "+sx);
        }
    }

    // 1.2.按姓名查询
    public void queryName(String name) throws SQLException {
        String sql = "SELECT * from cj where Xm = '"+name+"'";
        ResultSet res = statement.executeQuery(sql);
        System.out.println("学号  |  姓名  |  语文  |  数学");
        while (res.next()){
            String xueHao = res.getString("xuehao");
            String xm = res.getString("Xm");
            int yw = res.getInt("yw");
            int sx = res.getInt("Sx");
            System.out.println(xueHao +"  |  "+xm+"  |  "+yw+"  |  "+sx);
        }
    }


    // 添加功能
    public  void add() throws SQLException{
        System.out.println("请输入学号:");
        String xuehao = sc.next();
        System.out.println("请输入姓名:");
        String xm = sc.next();
        System.out.println("请输入语文成绩:");
        int yw = sc.nextInt();
        System.out.println("请输入数学成绩:");
        int sx = sc.nextInt();
        try {
            String sql = "INSERT INTO cj(xuehao,Xm,yw,Sx) VALUES ('" + xuehao + "','" + xm + "'," + yw + "," + sx + ")";
            int res = statement.executeUpdate(sql);
            if (res > 0) {
                System.out.println("添加成功");
            }
        } catch (SQLException e) {
            System.out.println("添加失败");
        }
    }

    // 修改功能
    public void update() throws SQLException {
        System.out.println("请输入要修改的学号:");
        String xuehao = sc.next();
        System.out.println("请输入要修改的姓名:");
        String xm = sc.next();
        System.out.println("请输入要修改的语文成绩:");
        int yw = sc.nextInt();
        System.out.println("请输入要修改的数学成绩:");
        int sx = sc.nextInt();
        try {
            String sql = "UPDATE cj SET xuehao = '" + xuehao + "',Xm = '" + xm + "',yw = " + yw + ",Sx = " + sx + " WHERE xuehao = '" + xuehao + "'";
            int res = statement.executeUpdate(sql);
            if (res > 0) {
                System.out.println("修改成功");
                query();
            }
        } catch (SQLException e) {
            System.out.println("修改失败");
        }

    }

    //  删除功能
    public void delete() throws SQLException {
        System.out.println("请输入要删除的学号:");
        String xuehao = sc.next();
        try {
            String sql = "DELETE FROM cj WHERE xuehao = '" + xuehao + "'";
            int res = statement.executeUpdate(sql);
            if (res > 0) {
                System.out.println("删除成功");
                query();
            }
        } catch (SQLException e) {
            System.out.println("删除失败");
        }
    }

}


