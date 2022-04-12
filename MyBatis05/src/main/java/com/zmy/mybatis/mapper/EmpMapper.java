package com.zmy.mybatis.mapper;

import com.zmy.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-11 21:32
 */
public interface EmpMapper {

    /**
     *  查询所有员工
     * @return
     */
    List<Emp> getAllEmp();

    /**
     *  查询员工以及员工对应部门的信息
     * @param eid
     * @return
     */
    Emp getEmpAndDept(@Param("eid")Integer eid);

    /**
     * 分步查询1
     *  查询员工信息
     * @param eid
     * @return
     */
    Emp getEmpAndDeptByStepOne(@Param("eid")Integer eid);

    /**
     * 通过部门查询部门以及部门中所有的员工信息
     *  分步查询2
     *  通过did获取部门员工
     *
     * @param did
     * @return
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did")Integer did);



}
