package com.zmy.mybatis;

import com.zmy.mybatis.mapper.UserMapper;
import com.zmy.mybatis.pojo.User;
import com.zmy.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-07 16:48
 */
public class TestMybatis {

    private SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    private UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

    @Test
    public void test1(){

        // 加载核心配配置文件
//            InputStream ras = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取sqlSessionFactory
//            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(ras);
        // 获取 SqlSession实例
//            SqlSession sqlSession = sessionFactory.openSession(true);// 设置自动提交事务

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        // 获取mapper接口是实现类实例
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int count = userMapper.getCount();
        System.out.println("count = " + count);
        List<User> allUser = userMapper.getAllUser();
        allUser.forEach(user -> System.out.println(user));
        System.out.println("------------------------------------");
        User user = userMapper.getUserByid(1);
        System.out.println("user = " + user);

    }

    @Test
    public void testLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User sam = userMapper.Login("sam", "123456");
        System.out.println("sam = " + sam);
    }
    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map map = new HashMap();
        map.put("uname","sam");
        map.put("upassword","123456");
        User user = userMapper.CheckLogin(map);
        System.out.println(user);
    }

    @Test
    public void testAddUser(){
        int zmy = userMapper.addUser(new User(null, "zmy", "1"));
        System.out.println("zmy = " + zmy);
    }

    @Test
    public void testAllUser(){
        List<User> allUser = userMapper.getAllUser();
        allUser.forEach(user -> System.out.println(user));
    }




}
