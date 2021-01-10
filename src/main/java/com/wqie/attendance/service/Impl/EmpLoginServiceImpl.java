package com.wqie.attendance.service.Impl;

import com.wqie.attendance.mapper.EmpLoginMapper;
import com.wqie.attendance.service.EmpLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpLoginServiceImpl implements EmpLoginService {
    @Autowired
    EmpLoginMapper empLoginMapper;

    public EmpLoginServiceImpl() {
    }

    public Integer selectCountIdByEmpno(String empno) {
        return this.empLoginMapper.selectCountIdByEmpno(empno);
    }

    public String selectPwdByEmpno(String empno) {
        return this.empLoginMapper.selectPwdByEmpno(empno);
    }
}
