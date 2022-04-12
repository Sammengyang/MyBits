package com.zmy.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-07 17:10
 */
public class SqlSessionUtils {

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        try {
            // 加载配置文件
            InputStream ras = Resources.getResourceAsStream("mybatis-config.xml");
            // 获取SqlSession 的工厂
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(ras);
            sqlSession = sessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
