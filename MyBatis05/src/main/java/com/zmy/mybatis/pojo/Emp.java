package com.zmy.mybatis.pojo;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-11 21:29
 */
public class Emp {
    private Integer eid;

    private String empName;

    private Integer age;

    private String sex;

    private Dept dept;


    public Emp() {
    }

    public Emp(Integer eid, String empName, Integer age, String sex, Dept dept) {
        this.eid = eid;
        this.empName = empName;
        this.age = age;
        this.sex = sex;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", dept=" + dept +
                '}';
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer edi) {
        this.eid = edi;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
