package com.wqie.attendance.mapper;

import com.wqie.attendance.model.BossLogin;

public interface BossLoginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BossLogin record);

    int insertSelective(BossLogin record);

    BossLogin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BossLogin record);

    int updateByPrimaryKey(BossLogin record);

    Integer selectCountIdByEmpno(String empno);

    String selectPwdByEmpno(String empno);
}