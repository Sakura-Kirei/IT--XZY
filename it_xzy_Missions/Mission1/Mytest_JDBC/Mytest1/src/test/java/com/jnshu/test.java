package com.jnshu;

import com.jnshu.demo.util.DatabaseConnection;
import com.jnshu.demo.vo.MyRealmp;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test{
    @Test
    public void selectTest() throws SQLException {
        String sql = "select * from students";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet set = pstmt.executeQuery();
        MyRealmp rs = new MyRealmp();
        while (set.next()){
            rs.setId(set.getInt("id"));
            rs.setName(set.getString("name"));
            rs.setSchool(set.getString("school"));
            rs.setOnline_un(set.getString("online_un"));
            rs.setNumber(set.getInt("number"));
            rs.setCity(set.getString("city"));
        }
        System.out.println("ID:"+rs.getId()+"  "+"Name:"+rs.getName()+"  "+"School:"+rs.getSchool()+"  "+"Online_un:"+rs.getOnline_un()+"  "+"Number:"+rs.getNumber()+"  "+"City:"+rs.getCity());
        DatabaseConnection.closeALL(conn,pstmt);
    }
}

