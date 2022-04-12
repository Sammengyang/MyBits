package com.zmy.mybatis;

import com.zmy.mybatis.mapper.UserMapper;
import com.zmy.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-11 9:47
 */
public class TestMybatis {

    static SqlSession sqlSession;

    public static void getSqlSession(){
        try {
            InputStream ras = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(ras);
            sqlSession = sessionFactory.openSession(true);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test1(){
        getSqlSession();
        System.out.println(sqlSession);
    }

    @Test
    public void testGetAllUser(){
        getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("第一次查询");
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(user -> System.out.println("user = " + user));
        // 关闭sqlSession
        sqlSession.close();
        getSqlSession();
        mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("第二次查询");
        allUser = mapper.getAllUser();
        allUser.forEach(user -> System.out.println("user = " + user));

    }
    @Test
    public void testGetUser(){
        getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User zmy = mapper.getUser("zmy");
        System.out.println("zmy = " + zmy);
    }



}
