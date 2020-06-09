package com.jnshu;


import com.jnshu.DataBaseConn.DataBaseConnection;
import com.jnshu.vo.MySql_Values;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class test {
@Test
    public void QueryForObject() {
        DataBaseConnection conn= new DataBaseConnection();
        String sql = "select * from students";
        RowMapper<MySql_Values> rowMapper = new BeanPropertyRowMapper<MySql_Values>(MySql_Values.class);
        List<MySql_Values> users = conn.getJdbcTemplate().query(sql, rowMapper);

        for (MySql_Values students : users) {
            System.out.println(students);

        }
    }
}