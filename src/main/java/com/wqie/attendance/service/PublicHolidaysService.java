package com.wqie.attendance.service;

import com.wqie.attendance.model.PublicHolidays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PublicHolidaysService {
    List<PublicHolidays> selectPHolidays(Integer year, Integer month);

    Integer insert(PublicHolidays publicHolidays);
}
