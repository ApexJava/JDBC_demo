package jdbc_first;

import org.junit.Test;

import java.sql.*;

public class jdbc_demo03 {
    @Test
    public void java_jdbc() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.创建连接
        String url = "jdbc:mysql://127.0.0.1:3306/webdb_1";
        Connection conn = DriverManager.getConnection(url, "root", "root");
        //3.编写SQL语句
        String sql = "select pid,pname,price from product where price>4000";
        //4.创建连接对象
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        //5.执行SQL返回值
        while (rs.next()){
            System.out.print(rs.getInt("pid")+"        ");
            System.out.print(rs.getString("pname")+"        ");
            System.out.println(rs.getInt("price")+"        ");
        }
        //6.释放资源
        rs.close();
        stmt.close();
        conn.close();

    }
}
