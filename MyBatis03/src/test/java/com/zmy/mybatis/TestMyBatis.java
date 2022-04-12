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
 * @create 2022-04-08 11:13
 */
public class TestMyBatis {

    private static SqlSession sqlSession = null;
    public static void getSqlSession(){
        try {
            // 加载配置文件
            InputStream ras = Resources.getResourceAsStream("mybatis03-config.xml");
            // 获取sqlFactory
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(ras);
            // 获取sqlsession
            sqlSession = sessionFactory.openSession(true); // 设置自动提交事务
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test1(){
        getSqlSession();
        System.out.println("sqlSession = " + sqlSession);
    }

    @Test
    public void testAddUser(){
        getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null, "sss", "1");
        int insert = sqlSession.insert("com.zmy.mybatis.mapper.UserMapper.addUser", user);
        System.out.println("insert = " + insert);
    }

    @Test
    public void testGetCount(){
        getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count = mapper.getCount();
        System.out.println("count = " + count);
    }
    @Test
    public void testDelUser(){
        getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.delUser(new User(14, null, null));
        System.out.println("i = " + i);
    }
    @Test
    public void testChangePassword(){
        getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.changePassword(new User(12, null, "22"));
        System.out.println("i = " + i);
    }

    @Test
    public void testgetAllUser(){
        getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(user -> System.out.println("user = " + user));
    }

}
