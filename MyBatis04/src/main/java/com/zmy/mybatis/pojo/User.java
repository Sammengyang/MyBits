package com.zmy.mybatis.pojo;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-09 9:14
 */
public class User {
    private Integer uid;
    private String uname;
    private String upassword;
    private Role role;

    public User() {
    }

    public User(Integer uid, String uname, String upassword) {
        this.uid = uid;
        this.uname = uname;
        this.upassword = upassword;
    }

    public User(Integer uid, String uname, String upassword, Role role) {
        this.uid = uid;
        this.uname = uname;
        this.upassword = upassword;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", role=" + role +
                '}';
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
}
