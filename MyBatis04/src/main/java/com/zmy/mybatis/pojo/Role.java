package com.zmy.mybatis.pojo;

import java.sql.Date;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-09 9:56
 */
public class Role {

    private Integer roid;
    private String roname;
    private String rodesc;
    private Date roaddTime;
    private Integer rostatus;

    public Role() {
    }

    public Role(Integer roid, String roname, String rodesc, Date roaddTime, Integer rostatus) {
        this.roid = roid;
        this.roname = roname;
        this.rodesc = rodesc;
        this.roaddTime = roaddTime;
        this.rostatus = rostatus;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roid=" + roid +
                ", roname='" + roname + '\'' +
                ", rodesc='" + rodesc + '\'' +
                ", roaddTime=" + roaddTime +
                ", rostatus=" + rostatus +
                '}';
    }

    public Integer getRoid() {
        return roid;
    }

    public void setRoid(Integer roid) {
        this.roid = roid;
    }

    public String getRoname() {
        return roname;
    }

    public void setRoname(String roname) {
        this.roname = roname;
    }

    public String getRodesc() {
        return rodesc;
    }

    public void setRodesc(String rodesc) {
        this.rodesc = rodesc;
    }

    public Date getRoaddTime() {
        return roaddTime;
    }

    public void setRoaddTime(Date roaddTime) {
        this.roaddTime = roaddTime;
    }

    public Integer getRostatus() {
        return rostatus;
    }

    public void setRostatus(Integer rostatus) {
        this.rostatus = rostatus;
    }
}
