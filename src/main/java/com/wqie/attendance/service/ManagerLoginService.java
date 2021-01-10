package com.wqie.attendance.service;

import org.springframework.stereotype.Service;

@Service
public interface ManagerLoginService {
    Integer selectCountIdByEmpno(String empno);

    String selectPwdByEmpno(String empno);
}
