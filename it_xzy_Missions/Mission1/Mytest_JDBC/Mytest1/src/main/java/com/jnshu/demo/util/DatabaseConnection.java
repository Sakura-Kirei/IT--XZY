package com.jnshu.demo.util;

import java.sql.*;

public class DatabaseConnection {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/it-xzy";
    private static final String user = "root";
    private static final String password = "54229103w";
    static{
        try{
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }

    public static void closeALL(Connection conn, PreparedStatement pstmt) throws SQLException{
        if(pstmt != null){
            pstmt.close();
        }
        if(conn != null){
            conn.close();
        }
    }
}



