package com.wqie.attendance.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.util.Date;

public class Emp {
    private Integer id;
    private String empno;
    private String ename;
    private String sex;
    private String job;
    @JsonFormat(
            shape = Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date hiredate;
    private String deptno;
    private Integer sal;
    private Integer comm;

    public Emp() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpno() {
        return this.empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getEname() {
        return this.ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getHiredate() {
        return this.hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getDeptno() {
        return this.deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public Integer getSal() {
        return this.sal;
    }

    public void setSal(Integer sal) {
        this.sal = sal;
    }

    public Integer getComm() {
        return this.comm;
    }

    public void setComm(Integer comm) {
        this.comm = comm;
    }
}
