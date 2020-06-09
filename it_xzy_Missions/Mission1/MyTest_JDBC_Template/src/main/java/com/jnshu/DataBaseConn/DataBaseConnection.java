package com.jnshu.DataBaseConn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DataBaseConnection {

    private  ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
    private JdbcTemplate jdbcTemplate = (JdbcTemplate) cxt.getBean("jdbcTemplate");

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}