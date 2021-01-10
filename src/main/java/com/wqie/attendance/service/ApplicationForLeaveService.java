package com.wqie.attendance.service;

import com.wqie.attendance.model.ApplicationForLeave;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ApplicationForLeaveService {
    List<ApplicationForLeave> selectAfterLeaves(String approverempno);

    Integer updatestates(Integer id, Integer state);

    Integer deleteMyAFL(Integer id);

    Integer insert(ApplicationForLeave applicationForLeave);

    List<ApplicationForLeave> dApplicationForLeave(String empno, Integer state);

    List<ApplicationForLeave> selectMyApplicationForLeave(String empno);
}
