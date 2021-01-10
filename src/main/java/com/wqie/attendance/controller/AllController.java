package com.wqie.attendance.controller;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AllController {
    public AllController() {
    }

    @RequestMapping({"/"})
    public String home() {
        return "login";
    }

    @RequestMapping({"login"})
    public String login() {
        return "login";
    }

    @RequestMapping({"index"})
    public String index() {
        return "index";
    }

    @RequestMapping({"empIndex"})
    public String empIndex(HttpSession session) {
        if (null == session.getAttribute("empno")) {
            return "login";
        } else {
            return "B" == session.getAttribute("power") ? "backgroundIndex" : "empIndex";
        }
    }

    @RequestMapping({"backgroundIndex"})
    public String backgroundIndex(HttpSession session) {
        if (null == session.getAttribute("empno")) {
            return "login";
        } else {
            return "A" == session.getAttribute("power") ? "empIndex" : "backgroundIndex";
        }
    }
}
