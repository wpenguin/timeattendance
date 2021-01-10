package com.wqie.attendance.service;

import com.wqie.attendance.model.Dept;
import org.springframework.stereotype.Service;

@Service
public interface DeptService {
    Dept selectMyDept(String deptno);
}
