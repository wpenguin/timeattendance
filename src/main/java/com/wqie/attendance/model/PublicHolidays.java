package com.wqie.attendance.model;

public class PublicHolidays {
    private Integer id;
    private Integer year;
    private Short month;
    private Short day;
    private Short days;
    private String phname;

    public PublicHolidays() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Short getMonth() {
        return this.month;
    }

    public void setMonth(Short month) {
        this.month = month;
    }

    public Short getDay() {
        return this.day;
    }

    public void setDay(Short day) {
        this.day = day;
    }

    public Short getDays() {
        return this.days;
    }

    public void setDays(Short days) {
        this.days = days;
    }

    public String getPhname() {
        return this.phname;
    }

    public void setPhname(String phname) {
        this.phname = phname;
    }
}
