package com.wqie.attendance.service.Impl;

import com.wqie.attendance.mapper.EmpMapper;
import com.wqie.attendance.model.Emp;
import com.wqie.attendance.service.EmpService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    public EmpServiceImpl() {
    }

    public Emp selectMyMaster(String deptno, String job) {
        Emp master = this.empMapper.selectMyManager(deptno, job);
        if (null != master) {
            master.setHiredate((Date)null);
            master.setSal((Integer)null);
            master.setComm((Integer)null);
        }

        return master;
    }

    public String selectMyDeptno(String empno) {
        return this.empMapper.selectMyDeptno(empno);
    }

    public Emp selectMyManager(String empno, String job) {
        return this.empMapper.selectMyManager(empno, job);
    }

    public Emp selectMyInformation(String empno) {
        return this.empMapper.selectMyInformation(empno);
    }
}
