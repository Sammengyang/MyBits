package com.zmy.mybatis.mapper;

import com.zmy.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-11 21:32
 */
public interface DeptMapper {


    /**
     * 分步查询2
     *  根据did查询员工所对应的部门信息
     * @param did
     * @return
     */
    Dept getEmpAndDeptByStepTwo(@Param("did")Integer did);

    /**
     *  获取部门以及部门中所有员工的信息
     *
     * @param did
     * @return
     */
    Dept getDeptAndEmp(@Param("did") Integer did);

    /**
     * 通过部门查询部门以及部门中所有的员工信息
     *  分步查询 1
     *  获取部门信息
     * @param did
     * @return
     */
    Dept getDeptAndEmpStepOne(@Param("did") Integer did);



}
