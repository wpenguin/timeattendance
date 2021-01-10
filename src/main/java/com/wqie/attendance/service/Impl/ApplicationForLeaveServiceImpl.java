package com.wqie.attendance.service.Impl;

import com.wqie.attendance.mapper.ApplicationForLeaveMapper;
import com.wqie.attendance.model.ApplicationForLeave;
import com.wqie.attendance.service.ApplicationForLeaveService;
import com.wqie.attendance.tool.Mailling;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationForLeaveServiceImpl implements ApplicationForLeaveService {
    @Autowired
    ApplicationForLeaveMapper applicationForLeaveMapper;
    @Autowired
    Mailling mailling;

    public ApplicationForLeaveServiceImpl() {
    }

    public Integer deleteMyAFL(Integer id) {
        return this.applicationForLeaveMapper.deleteByPrimaryKey(id);
    }

    public Integer insert(ApplicationForLeave applicationForLeave) {
        applicationForLeave.setId(this.applicationForLeaveMapper.selectMaxId() + 1);
        if (1 == this.applicationForLeaveMapper.insert(applicationForLeave)) {
            this.mailling.sendSimpleMail(applicationForLeave.getApplicantempno());
            return 1;
        } else {
            return 0;
        }
    }

    public List<ApplicationForLeave> dApplicationForLeave(String empno, Integer state) {
        return this.applicationForLeaveMapper.dApplicationForLeave(empno, state);
    }

    public List<ApplicationForLeave> selectMyApplicationForLeave(String empno) {
        return this.applicationForLeaveMapper.selectMyApplicationForLeave(empno);
    }

    public List<ApplicationForLeave> selectAfterLeaves(String approverempno) {
        return this.applicationForLeaveMapper.selectAfterLeaves(approverempno);
    }

    public Integer updatestates(Integer id, Integer state) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String approvaltime = simpleDateFormat.format(date);
        return this.applicationForLeaveMapper.updatestate(id, approvaltime, state);
    }
}
