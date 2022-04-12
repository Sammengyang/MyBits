package com.zmy.mybatis;

import com.zmy.mybatis.mapper.UserMapper;
import com.zmy.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-09 9:18
 */
public class TestMyBatis {
    static UserMapper userMapper = SqlSessionUtils.getSqlSession().getMapper(UserMapper.class);

    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        System.out.println("sqlSession = " + sqlSession);
    }

    @Test
    public void testgetAllUser(){
        List<User> allUser = userMapper.getAllUser();
        allUser.forEach(user -> System.out.println("user = " + user));
    }

    @Test
    public void testGetUserRole(){
        List<User> userRole = userMapper.getUserRole();
        userRole.forEach(ur -> System.out.println("ur = " + ur));
    }
}
