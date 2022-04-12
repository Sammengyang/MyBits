package com.zmy.mybatis;

import com.zmy.mybatis.mapper.SelectMapper;
import com.zmy.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-11 18:09
 */
public class SelectMapperTest {
    static SelectMapper selectMapper = null;
    @Before
    public void getMapper(){
        try {
            InputStream ras = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(ras);
            SqlSession sqlSession = sessionFactory.openSession(true);
            selectMapper = sqlSession.getMapper(SelectMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * MyBatis 的个中国查询功能
     * 1. 若查询的智友一条，可以通过实体类对象或者集合接收
     * 2. 若查询的数据由多条，一定不能通过实体类接收，只通过List集合接收
     */
    @Test
    public void testGetUserById(){
        User userById = selectMapper.getUserById(11);
        System.out.println("userById = " + userById);
    }

    @Test
    public void testGetAllUser(){
        List<User> allUser = selectMapper.getAllUser();
        allUser.forEach(user -> System.out.println("user = " + user));
    }

    @Test
    public void testGetCount(){
        Integer count = selectMapper.getCount();
        System.out.println("count = " + count);
    }

    @Test
    public void testGetUserByIdToMap(){
        Map<String, Object> userByIdToMap = selectMapper.getUserByIdToMap(11);
        System.out.println("userByIdToMap = " + userByIdToMap);
    }

    @Test
    public void testGetAllUserToMap(){
//        List<Map<String, Object>> allUserToMap = selectMapper.getAllUserToMap();
//        allUserToMap.forEach(usermap -> System.out.println("usermap = " + usermap));
        Map<String, Object> allUserToMap = selectMapper.getAllUserToMap();
        System.out.println("allUserToMap = " + allUserToMap);
    }

    @Test
    public void testGetUserByLike(){
        List<User> m = selectMapper.getUserByLike("m");
        m.forEach( s -> System.out.println("s = " + s));
    }

    @Test
    public void testDeleteMore(){
        int i = selectMapper.deleteMore("15,16,17");
        System.out.println("i = " + i);
    }
    @Test
    public void testGetUserByTable(){
        List<User> user = selectMapper.getUserByTable("user");
        user.forEach(user1 -> System.out.println("user1 = " + user1));
    }

    @Test
    public void testInsertUser(){
        User user = new User(null, "sss", "1");
        selectMapper.insertUser(user);
        System.out.println("user = " + user);

    }








}
