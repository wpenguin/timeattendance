package com.wqie.attendance.controller;

import com.wqie.attendance.model.Emp;
import com.wqie.attendance.service.EmpService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmpController {
    @Autowired
    EmpService empServiceImpl;

    public EmpController() {
    }

    @PostMapping({"selectMyInformation"})
    @ResponseBody
    public Emp selectMyInformation(HttpSession session) {
        return this.empServiceImpl.selectMyInformation((String)session.getAttribute("empno"));
    }

    @PostMapping({"selectMyMaster"})
    @ResponseBody
    public Emp selectMyMster(String deptno) {
        return this.empServiceImpl.selectMyMaster(deptno, "%经理");
    }
}
