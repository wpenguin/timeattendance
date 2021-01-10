package com.wqie.attendance.service;

import org.springframework.stereotype.Service;

@Service
public interface EmpLoginService {
    Integer selectCountIdByEmpno(String empno);

    String selectPwdByEmpno(String empno);
}
