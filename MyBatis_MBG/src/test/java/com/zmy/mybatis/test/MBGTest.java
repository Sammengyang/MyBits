package com.zmy.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zmy.mybatis.mapper.EmpMapper;
import com.zmy.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-12 17:48
 */
public class MBGTest {

    static SqlSession sqlSession = null;
    static EmpMapper empMapper = null;

    @Before
    public void getSqlSession(){
        try {
            InputStream ras = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ras);
            sqlSession = sqlSessionFactory.openSession(true);
            empMapper = sqlSession.getMapper(EmpMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testMBG(){
        // 修改
//        int updateByPrimaryKey = empMapper.updateByPrimaryKey(new Emp(11, "sam", 20, null));
        int updateByPrimaryKey = empMapper.updateByPrimaryKeySelective(new Emp(11, "sam", 20, null));
        System.out.println("updateByPrimaryKey = " + updateByPrimaryKey);
    }


    @Test
    public void testPageHelper(){
        Page<Object> page = PageHelper.startPage(6, 4);
        List<Emp> empList = empMapper.selectByExample(null);
        empList.forEach(System.out::println);
        System.out.println("page = " + page);
        // 方法二
        PageInfo<Emp> pageInfo = new PageInfo<>(empList,3);
        int[] navigatePages = pageInfo.getNavigatepageNums();
        System.out.println("page2 = " + pageInfo);
    }



}
