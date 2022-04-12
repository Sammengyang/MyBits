package com.zmy.mybatis.mapper;

import com.zmy.mybatis.pojo.User;

import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-09 9:14
 */
public interface UserMapper {

    /**
     * 获取所有用户
     * @return
     */
    List<User> getAllUser();

    /**
     * 获取所用用户的的权限信息
     * @return
     */
    List<User> getUserRole();
}
