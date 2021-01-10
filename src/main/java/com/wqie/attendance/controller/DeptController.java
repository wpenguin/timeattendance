package com.wqie.attendance.controller;

import com.wqie.attendance.model.Dept;
import com.wqie.attendance.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeptController {
    @Autowired
    DeptService deptServiceImpl;

    public DeptController() {
    }

    @RequestMapping({"selectMyDept"})
    @ResponseBody
    public Dept selectMyDept(String deptno) {
        return this.deptServiceImpl.selectMyDept(deptno);
    }
}
