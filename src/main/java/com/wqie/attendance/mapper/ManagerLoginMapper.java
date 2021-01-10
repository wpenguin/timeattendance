package com.wqie.attendance.mapper;

import com.wqie.attendance.model.ManagerLogin;

public interface ManagerLoginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ManagerLogin record);

    int insertSelective(ManagerLogin record);

    ManagerLogin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ManagerLogin record);

    int updateByPrimaryKey(ManagerLogin record);

    Integer selectCountIdByEmpno(String empno);

    String selectPwdByEmpno(String empno);
}
