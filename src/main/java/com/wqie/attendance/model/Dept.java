package com.wqie.attendance.model;

public class Dept {
    private Integer id;
    private String deptno;
    private String dname;
    private String telephone;

    public Dept() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptno() {
        return this.deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return this.dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
