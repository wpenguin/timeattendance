package com.wqie.attendance.mapper;

import com.wqie.attendance.model.ApplicationForLeave;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplicationForLeaveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApplicationForLeave record);

    int insertSelective(ApplicationForLeave record);

    ApplicationForLeave selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApplicationForLeave record);

    int updateByPrimaryKey(ApplicationForLeave record);

    Integer selectMaxId();

    List<ApplicationForLeave> selectMyApplicationForLeave(String applicantempno);

    List<ApplicationForLeave> dApplicationForLeave(String approverempno, Integer state);

    Integer updatestate(@Param("id") Integer id, @Param("approvaltime") String approvaltime, @Param("state") Integer state);

    List<ApplicationForLeave> selectAfterLeaves(String approverempno);
}

