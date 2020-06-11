package com.jnshu.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
/**
 * 类名采用UpperCamelCase风格
 * @author 王振宇
 * 2020.6.10
 *
 * 获取SqlSeesion
 */
public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static SqlSession getSeesion(){
        return sqlSessionFactory.openSession();
    }
}





