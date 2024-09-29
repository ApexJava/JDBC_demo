package jdbc_first;

import org.junit.Test;

import java.sql.*;

public class jdbc_demo01 {

    @Test
    public void jdbcdemo() throws SQLException, ClassNotFoundException {
        //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");



        //2.连接数据库
        String url = "jdbc:mysql://127.0.0.1:3306/webdb_1";
        Connection conn = DriverManager.getConnection(url, "root", "root");

        //3.编写 SQL命令
        String SQL = "select pid,pname,price from product";


        //4.发送SQL命令给Mysql
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        //5.处理SQL的执行结果
        while (rs.next()){
            System.out.print(rs.getInt("pid")+"\t");
            System.out.print(rs.getString("pname")+"\t");
            System.out.println(rs.getInt("price")+"\t");
            System.out.println("---------------------");
        }


        //6.释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
