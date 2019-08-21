package cn.joharxiao.util;

import java.sql.*;

public class JdbcUtil {
    private static Connection con;
    static{
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaeetest?useSSL=false","root","root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getCon(){
        return con;
    }
    public static void close (Connection con, Statement st, ResultSet rs){
        try {
            if(con!=null){
                con.close();
            }
            if(st!=null){
                st.close();
            }
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection con,Statement st) throws SQLException{
        close(con,st,null);
    }
}
