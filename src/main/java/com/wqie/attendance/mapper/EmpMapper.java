package com.wqie.attendance.mapper;

import com.wqie.attendance.model.Emp;

public interface EmpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

    Emp selectMyInformation(String empno);

    String selectMyDeptno(String empno);

    Emp selectMyManager(String deptno, String job);
}
