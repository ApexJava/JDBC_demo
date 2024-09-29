package jdbc_first;

import org.junit.Test;

import java.sql.*;

public class jdbc_demo02 {
    @Test
    public void java_jdbc() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/webdb_1";
        Connection conn = DriverManager.getConnection(url, "root", "root");

        String sql = "Select pid AS id,pname,price from product";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()){
            System.out.print(rs.getInt("id")+"    ");
            System.out.print(rs.getString("pname")+"   ");
            System.out.println(rs.getInt("price"));
        }
        rs.close();
        stmt.close();
        conn.close();

    }
}
