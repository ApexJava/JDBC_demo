package daytwo;

import org.junit.Test;

import java.sql.*;

public class jdbc_p {
    @Test
    public void method_prepared() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        String url ="jdbc:mysql://127.0.0.1:3306/webdb_1";
        Connection conn = DriverManager.getConnection(url, "root", "root");

        //3.编写SQL
        String sql = "select pid,pname,price from product where price >?";
        //4.创建sql连接对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //为预编译“？”赋值

        pstmt.setInt(1,4000);

        ResultSet rs = pstmt.executeQuery();
        //有一个
        while (rs.next()){
            System.out.print(rs.getInt("pid")+"      ");
            System.out.print(rs.getString("pname")+"       ");
            System.out.println(rs.getInt("price")+"        ");
        }

        rs.close();
        pstmt.close();
        conn.close();
    }
}
