package com.zmy.mybatis.mapper;

import com.zmy.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-07 16:43
 */
public interface UserMapper {


    /**
     * 获取总用户数
     * @return
     */
    int getCount();

    /**
     * 获取所用用户信息
     * @return
     */
    List<User> getAllUser();


    /**
     * 根据id获取用户信息
     * @param uid
     * @return
     */
    User getUserByid(@Param(value="uid") Integer uid);

    /**
     * 登录
     * @param uname     用户名
     * @param upassword 密码
     * @return
     */
    User Login(String uname,String upassword);

    /**
     * 检测登录
     * @param map
     * @return
     */
    User CheckLogin(Map<String,String> map);


    /**
     * 添加一个用户
     * @param user
     * @return
     */
    int addUser(User user);

}
