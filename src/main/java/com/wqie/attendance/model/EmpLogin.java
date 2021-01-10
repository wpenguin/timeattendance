package com.wqie.attendance.model;

public class EmpLogin {
    private Integer id;
    private String empno;
    private String pwd;

    public EmpLogin() {
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

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
