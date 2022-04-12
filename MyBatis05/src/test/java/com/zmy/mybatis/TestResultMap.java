package com.zmy.mybatis;

import com.zmy.mybatis.mapper.DeptMapper;
import com.zmy.mybatis.mapper.EmpMapper;
import com.zmy.mybatis.mapper.SelectMapper;
import com.zmy.mybatis.pojo.Dept;
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
 * @create 2022-04-11 21:22
 */
public class TestResultMap {

    static EmpMapper empMapper = null;
    static DeptMapper deptMapper = null;
    @Before
    public void getMapper(){
        try {
            InputStream ras = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(ras);
            SqlSession sqlSession = sessionFactory.openSession(true);
            empMapper = sqlSession.getMapper(EmpMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Before
    public void getdEPTMapper(){
        try {
            InputStream ras = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(ras);
            SqlSession sqlSession = sessionFactory.openSession(true);
            deptMapper = sqlSession.getMapper(DeptMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        List<Emp> allEmp = empMapper.getAllEmp();
        allEmp.forEach(emp -> System.out.println("emp = " + emp));
    }
    @Test
    public void testGetEmpAndDept(){
        Emp empAndDept = empMapper.getEmpAndDept(1);
        System.out.println("empAndDept = " + empAndDept);
    }

    @Test
    public void testGetEmpAndDeptByStep(){
        Emp emp = empMapper.getEmpAndDeptByStepOne(1);
        System.out.println("emp = " + emp.getEmpName());
        System.out.println("---------------------");
        System.out.println(emp.getDept());

    }

    @Test
    public void testGetDeptAndEmp(){
        Dept deptAndEmp = deptMapper.getDeptAndEmp(1);
        System.out.println("deptAndEmp = " + deptAndEmp);
    }

    @Test
    public void testGetDeptAndEmpByStep(){
        Dept deptAndEmp = deptMapper.getDeptAndEmpStepOne(1);
        System.out.println("deptAndEmp = " + deptAndEmp.getDeptName());
    }
}
