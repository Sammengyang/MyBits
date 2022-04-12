package com.zmy.mybatis.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-11 9:26
 */
public class User implements Serializable {
    private Integer uid;
    private String uname;
    private String upassword;
    private List<Role> roles;

    public User() {
    }

    public User(Integer uid, String uname, String upassword, List<Role> roles) {
        this.uid = uid;
        this.uname = uname;
        this.upassword = upassword;
        this.roles = roles;
    }

    public User(Integer uid, String uname, String upassword) {
        this.uid = uid;
        this.uname = uname;
        this.upassword = upassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", roles=" + roles +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public List<Role> getRole() {
        return roles;
    }

    public void setRole(List<Role> role) {
        this.roles = roles;
    }
}
