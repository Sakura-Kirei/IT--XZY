package com.jnshu.impl;

import com.jnshu.DataBaseConn.DataBaseConnection;
import com.jnshu.interfaceDAO.DAO_interface;
import com.jnshu.vo.MySql_Values;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class Do_Mysqls implements DAO_interface {

@Test
    public void QueryForObject() {
        //DataBaseConnection conn = new DataBaseConnection();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        DataBaseConnection dataBaseConnection = (DataBaseConnection) context.getBean("dataBaseConnection");
        String sql = "select * from students";
        RowMapper<MySql_Values> rowMapper = new BeanPropertyRowMapper<MySql_Values>(MySql_Values.class);
        List<MySql_Values> users = dataBaseConnection.getJdbcTemplate().query(sql, rowMapper);

        for (MySql_Values students : users){
            System.out.println(students);
        }

    }
}
