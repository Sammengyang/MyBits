package com.zmy.mybatis;

import com.zmy.mybatis.mapper.DynamicMapper;
import com.zmy.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-12 10:26
 */
public class TestDynamicSql {

    static DynamicMapper dynamicMapper = null;

    @Before
    public void getMapper(){
        try {
            InputStream ras = Resources.getResourceAsStream("mybatis06-config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(ras);
            SqlSession sqlSession = sessionFactory.openSession(true);
            dynamicMapper = sqlSession.getMapper(DynamicMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetEmpByCondition(){
        Emp emp = new Emp(1, null, 12);
        List<Emp> empList = dynamicMapper.getEmpByCondition(emp);
        empList.forEach(e-> System.out.println("e = " + e));
    }

    @Test
    public void testGetEmpByChoose(){
        Emp emp = new Emp(1, null, 12);
        List<Emp> empList = dynamicMapper.getEmpByChoose(emp);
        empList.forEach(e-> System.out.println("e = " + e));
    }

    @Test
    public void testDeleteMoreByArray(){
        int i = dynamicMapper.deleteMoreByArray(new Integer[]{9,10});
        System.out.println("i = " + i);
    }

    @Test
    public void testInsertMoreByList(){
        List<Emp> list = new ArrayList<>();
        list.add(new Emp(null,"s",10));
        list.add(new Emp(null,"sds",23));
        list.add(new Emp(null,"sfs",34));
        int i = dynamicMapper.insertMoreByList(list);
        System.out.println("i = " + i);
    }



}
