package com.zmy.mapper;

import com.zmy.pojo.User;

import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description 充当了dao层
 * @create 2022-04-07 10:32
 */
public interface UserMapper {

    /**
     *  MyBatis面向接口编程的两个一致
     *  1. 映射文件的namespace 要和mapper接口的全类名保持一致
     *  2. 映射文件中的SQL语句的id要和mapper接口中的方法名一致
     */


    /**
     * 添加用户
     * @return
     */
    int insertUser();

    /**
     * 根据id查询用户信息
     * @return
     */
    User getUser();

    /**
     * 查询所有用户
     * @return
     */
    List<User> getUserList();

    /**
     * 根据id删除用户
     * @param user
     * @return
     */
    int delUserByUid(User user);

    /**
     * 根据id修改用户信息
     * @param user
     * @return
     */
    int updateUserByUid(User user);

    /**
     * 查询用户总数
     * @return
     */
    int getCount();
}
