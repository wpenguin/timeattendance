package com.wqie.attendance.mapper;

import com.wqie.attendance.model.PublicHolidays;
import java.util.List;

public interface PublicHolidaysMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PublicHolidays record);

    int insertSelective(PublicHolidays record);

    PublicHolidays selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PublicHolidays record);

    int updateByPrimaryKey(PublicHolidays record);

    List<PublicHolidays> selectPHolidays(Integer year, Integer month);

    Integer selectMaxId();
}
