package com.wqie.attendance.service.Impl;

import com.wqie.attendance.mapper.PublicHolidaysMapper;
import com.wqie.attendance.model.PublicHolidays;
import com.wqie.attendance.service.PublicHolidaysService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicHolidaysServiceImpl implements PublicHolidaysService {
    @Autowired
    PublicHolidaysMapper publicHolidaysMapper;

    public PublicHolidaysServiceImpl() {
    }

    public List<PublicHolidays> selectPHolidays(Integer year, Integer month) {
        return this.publicHolidaysMapper.selectPHolidays(year, month);
    }

    public Integer insert(PublicHolidays publicHolidays) {
        publicHolidays.setId(this.publicHolidaysMapper.selectMaxId() + 1);
        return this.publicHolidaysMapper.insert(publicHolidays);
    }
}
