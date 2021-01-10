package com.wqie.attendance.service;

import com.wqie.attendance.model.Emp;
import org.springframework.stereotype.Service;

@Service
public interface EmpService {
    Emp selectMyMaster(String deptno, String job);

    String selectMyDeptno(String empno);

    Emp selectMyManager(String empno, String job);

    Emp selectMyInformation(String empno);
}
