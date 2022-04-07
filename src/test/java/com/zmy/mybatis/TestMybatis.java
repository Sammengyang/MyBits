package com.zmy.mybatis;

import com.zmy.mapper.UserMapper;
import com.zmy.pojo.User;
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
 * @create 2022-04-07 11:12
 */
public class TestMybatis {


    /**
     * SqlSession默认不自动提交事务，若需要自动提交事务可以使用
     * SqlSession sqlSession = factory.openSession(true)
     */

    @Test
    public void test1(){
        try {
            // 加载核心配置问价，获取输入流
            InputStream ras = Resources.getResourceAsStream("mybatis-config.xml");
            // 获取sqlSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(ras);
            // 获取sqlSession实例
            SqlSession sqlSession = factory.openSession(true);// 设置自动提交事务
            // 参数是 sql的路径
            int count = sqlSession.selectOne("com.zmy.mapper.UserMapper.getCount");
            // 获取mapper接口的对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            count = mapper.getCount();
            System.out.println("count = " + count);
//            int insertUser = mapper.insertUser();
//            System.out.println("insertUser = " + insertUser);
            // 手动提交事务
//            sqlSession.commit();
//            User user = mapper.getUser();
//            System.out.println("user = " + user);
            List<User> userList = mapper.getUserList();
            System.out.println("userList.size() = " + userList.size());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
