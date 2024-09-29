package jdbc_first;

import java.sql.*;

public class jdbc_Util {

    static final String Drive = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://127.0.0.1:3306/webdb_1";
    static final String username = "root";
    static final String password = "root";


    public void close(ResultSet rs, Statement stmt, Connection conn) throws SQLException {
        rs.close();
        stmt.close();
        conn.close();
    }

    public void close(ResultSet rs, PreparedStatement  pstmt, Connection conn) throws SQLException {
        rs.close();
        pstmt.close();
        conn.close();
    }


}

