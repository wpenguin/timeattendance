package com.wqie.attendance.mapper;

import com.wqie.attendance.model.EmpLogin;

public interface EmpLoginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmpLogin record);

    int insertSelective(EmpLogin record);

    EmpLogin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmpLogin record);

    int updateByPrimaryKey(EmpLogin record);

    Integer selectCountIdByEmpno(String empno);

    String selectPwdByEmpno(String empno);
}

