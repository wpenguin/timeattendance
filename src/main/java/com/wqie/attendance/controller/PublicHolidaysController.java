package com.wqie.attendance.controller;

import com.wqie.attendance.model.PublicHolidays;
import com.wqie.attendance.service.PublicHolidaysService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PublicHolidaysController {
    @Autowired
    PublicHolidaysService publicHolidaysServiceImpl;

    public PublicHolidaysController() {
    }

    @RequestMapping({"selectPHolidays"})
    @ResponseBody
    public List<PublicHolidays> selectPHolidays(Integer year, Integer month) {
        return this.publicHolidaysServiceImpl.selectPHolidays(year, month);
    }

    @RequestMapping({"insertPH"})
    @ResponseBody
    public Integer insertPH(PublicHolidays publicHolidays) {
        return this.publicHolidaysServiceImpl.insert(publicHolidays);
    }
}
