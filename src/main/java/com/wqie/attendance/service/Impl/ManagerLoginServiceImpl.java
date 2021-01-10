package com.wqie.attendance.service.Impl;

import com.wqie.attendance.mapper.ManagerLoginMapper;
import com.wqie.attendance.service.ManagerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerLoginServiceImpl implements ManagerLoginService {
    @Autowired
    ManagerLoginMapper managerLoginMapper;

    public ManagerLoginServiceImpl() {
    }

    public Integer selectCountIdByEmpno(String empno) {
        return this.managerLoginMapper.selectCountIdByEmpno(empno);
    }

    public String selectPwdByEmpno(String empno) {
        return this.managerLoginMapper.selectPwdByEmpno(empno);
    }
}
