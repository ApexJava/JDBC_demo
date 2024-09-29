package jdbc_first;

import org.junit.Test;

import java.sql.*;

public class jdbc_demo04 extends jdbc_Util{
    @Test
    public void java_jdbc() throws ClassNotFoundException, SQLException {
        Class.forName(Drive);

        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "select pid,pname,price from product where price>4000";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            System.out.print(rs.getInt("pid")+"        ");
            System.out.print(rs.getString("pname")+"        ");
            System.out.println(rs.getInt("price")+"        ");
        }

        close(rs,stmt,conn);
    }
}
