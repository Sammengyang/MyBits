package com.zmy.mybatis.mapper;

import com.zmy.mybatis.pojo.User;

import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-11 9:31
 */
public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     */
    List<User> getAllUser();

    /**
     * 根据用户名获取账户信息
     * @param uname
     * @return
     */
    User getUser(String uname);

}
