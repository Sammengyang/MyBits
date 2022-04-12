package com.zmy.mybatis.mapper;

import com.zmy.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-11 18:04
 */
public interface SelectMapper {

    /**
     * 根据id查询用户信息
     *
     * @param uid
     * @return
     */
    User getUserById(@Param(value = "uid") Integer uid);

    /**
     * 查询所有账户
     * @return
     */
    List<User> getAllUser();

    /**
     * 查询用户数
     * @return
     */
    Integer getCount();

    /**
     *  根据id查询用户
     * @param uid
     * @return
     */
    Map<String,Object> getUserByIdToMap(@Param(value = "uid") Integer uid);

    /**
     *  查询所有用户信息为map集合
     *
     * @return
     */
//    List<Map<String, Object>> getAllUserToMap();
    @MapKey("uid")
    Map<String,Object> getAllUserToMap();

    /**
     *  根据用户名模糊查询数据
     * @param uname
     * @return
     */
    List<User> getUserByLike(@Param(value = "uname") String uname);

    /**
     * 批量删除
     * @return
     */
    int  deleteMore(@Param(value = "uids") String uids);

    /**
     * 查询指定表中数据
     * @param tableName
     * @return
     */
    List<User> getUserByTable(@Param("tableName") String tableName);

    /**
     *  添加用户
     *
     * @param user
     * @return
     */
    int insertUser(User user);

}
