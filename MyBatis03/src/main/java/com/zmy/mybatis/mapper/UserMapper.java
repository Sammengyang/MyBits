package com.zmy.mybatis.mapper;

import com.zmy.mybatis.pojo.User;

import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-08 11:10
 */
public interface UserMapper {
    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    int delUser(User user);

    /**
     * 修改密码
     * @param user
     * @return
     */
    int changePassword(User user);

    /**
     * 获取所有用户
     * @return
     */
    List<User> getAllUser();


    /**
     * 获取总数
     * @return
     */
    int getCount();
}
