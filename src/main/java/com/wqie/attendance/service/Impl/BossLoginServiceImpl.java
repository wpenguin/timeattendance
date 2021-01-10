package com.wqie.attendance.service.Impl;

import com.wqie.attendance.mapper.BossLoginMapper;
import com.wqie.attendance.service.BossLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BossLoginServiceImpl implements BossLoginService {
    @Autowired
    BossLoginMapper bossLoginMapper;

    public BossLoginServiceImpl() {
    }

    public Integer selectCountIdByEmpno(String empno) {
        return this.bossLoginMapper.selectCountIdByEmpno(empno);
    }

    public String selectPwdByEmpno(String empno) {
        return this.bossLoginMapper.selectPwdByEmpno(empno);
    }
}
