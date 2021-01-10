package com.wqie.attendance.controller;

import com.wqie.attendance.service.BossLoginService;
import com.wqie.attendance.service.EmpLoginService;
import com.wqie.attendance.service.ManagerLoginService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    EmpLoginService empLoginServiceImpl;
    @Autowired
    ManagerLoginService managerLoginServiceImpl;
    @Autowired
    BossLoginService bossLoginServiceImpl;

    public LoginController() {
    }

    @RequestMapping({"logout"})
    public String logout(HttpSession session) {
        session.removeAttribute("empno");
        return "login";
    }

    @RequestMapping({"loginCheck"})
    public String loginCheck(Integer profession, String empno, String pwd, Model model, HttpSession session) {
        if (profession == null) {
            model.addAttribute("professionerror", "请选择职位！！！");
            return "login";
        } else if (1 == profession) {
            if (0 == this.empLoginServiceImpl.selectCountIdByEmpno(empno)) {
                model.addAttribute("empnoerror", "工号不存在！！！");
                return "login";
            } else if (!pwd.equals(this.empLoginServiceImpl.selectPwdByEmpno(empno))) {
                model.addAttribute("pwderror", "密码错误！！！");
                return "login";
            } else {
                session.setAttribute("power", "A");
                session.setAttribute("empno", empno);
                return "empIndex";
            }
        } else if (2 == profession) {
            if (0 == this.managerLoginServiceImpl.selectCountIdByEmpno(empno)) {
                model.addAttribute("empnoerror", "工号不存在！！！");
                return "login";
            } else if (!pwd.equals(this.managerLoginServiceImpl.selectPwdByEmpno(empno))) {
                model.addAttribute("pwderror", "密码错误！！！");
                return "login";
            } else {
                session.setAttribute("power", "B");
                session.setAttribute("empno", empno);
                return "empIndex";
            }
        } else if (3 == profession) {
            if (0 == this.bossLoginServiceImpl.selectCountIdByEmpno(empno)) {
                model.addAttribute("empnoerror", "工号不存在！！！");
                return "login";
            } else if (!pwd.equals(this.bossLoginServiceImpl.selectPwdByEmpno(empno))) {
                model.addAttribute("pwderror", "密码错误！！！");
                return "login";
            } else {
                session.setAttribute("power", "C");
                session.setAttribute("empno", empno);
                return "bossIndex";
            }
        } else {
            return "login";
        }
    }
}

