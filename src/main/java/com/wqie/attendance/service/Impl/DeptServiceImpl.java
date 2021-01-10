package com.wqie.attendance.service.Impl;

import com.wqie.attendance.mapper.DeptMapper;
import com.wqie.attendance.model.Dept;
import com.wqie.attendance.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;

    public DeptServiceImpl() {
    }

    public Dept selectMyDept(String deptno) {
        return this.deptMapper.selectMyDept(deptno);
    }
}
