package com.wqie.attendance.controller;
import com.wqie.attendance.model.ApplicationForLeave;
import com.wqie.attendance.service.ApplicationForLeaveService;
import com.wqie.attendance.service.EmpService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplicationForLeaveController {
    @Autowired
    ApplicationForLeaveService applicationForLeaveServiceImpl;
    @Autowired
    EmpService empServiceImpl;

    public ApplicationForLeaveController() {
    }

    @RequestMapping({"addAFL"})
    @ResponseBody
    public ApplicationForLeave addAFL(HttpSession session) {
        ApplicationForLeave applicationForLeave = new ApplicationForLeave();
        applicationForLeave.setApplicantempno((String)session.getAttribute("empno"));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(new Date());
        applicationForLeave.setLeavetime(date);
        applicationForLeave.setState(Short.valueOf((short)0));
        if ("A".equals(session.getAttribute("empno").toString().substring(0, 1))) {
            applicationForLeave.setApproverempno(this.empServiceImpl.selectMyManager(this.empServiceImpl.selectMyDeptno((String)session.getAttribute("empno")), "%经理").getEmpno());
        }

        if ("B".equals(session.getAttribute("empno").toString().substring(0, 1))) {
            applicationForLeave.setApproverempno("C39001");
        }

        return applicationForLeave;
    }

    @RequestMapping({"insert"})
    @ResponseBody
    public Integer insert(ApplicationForLeave applicationForLeave) {
        return this.applicationForLeaveServiceImpl.insert(applicationForLeave);
    }

    @RequestMapping({"selectMyApplicationForLeave"})
    @ResponseBody
    public List<ApplicationForLeave> selectMyApplicationForLeave(HttpSession session) {
        return this.applicationForLeaveServiceImpl.selectMyApplicationForLeave((String)session.getAttribute("empno"));
    }

    @RequestMapping({"dApplicationForLeave"})
    @ResponseBody
    public List<ApplicationForLeave> dApplicationForLeave(HttpSession session, Integer state) {
        return this.applicationForLeaveServiceImpl.dApplicationForLeave((String)session.getAttribute("empno"), state);
    }

    @RequestMapping({"updatestate"})
    @ResponseBody
    public Integer updatestate(Integer id, Integer state) {
        return this.applicationForLeaveServiceImpl.updatestates(id, state);
    }

    @RequestMapping({"selectAfterLeaves"})
    @ResponseBody
    public List<ApplicationForLeave> selectAfterLeaves(String empno) {
        return this.applicationForLeaveServiceImpl.selectAfterLeaves(empno);
    }

    @RequestMapping({"deleteMyAFL"})
    @ResponseBody
    public Integer deleteMyAFL(Integer id) {
        return this.applicationForLeaveServiceImpl.deleteMyAFL(id);
    }
}
