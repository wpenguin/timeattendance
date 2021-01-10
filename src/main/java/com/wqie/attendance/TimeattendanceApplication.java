package com.wqie.attendance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.wqie.attendance.mapper"})
public class TimeattendanceApplication {
    public TimeattendanceApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(TimeattendanceApplication.class, args);
    }
}
