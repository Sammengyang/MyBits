package com.zmy.mybatis.mapper;

import com.zmy.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-12 10:24
 */
public interface DynamicMapper {

    /**
     *  多条件查询
     *
     * @param emp
     * @return
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     *  测试choose、when、otherwise
     * @param emp
     * @return
     */
    List<Emp> getEmpByChoose(Emp emp);


    /**
     * 通过数组批量删除
     *
     * @param eids
     * @return
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);


    /**
     *  通过list集合批量添加
     *
     * @param emps
     * @return
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);

}
