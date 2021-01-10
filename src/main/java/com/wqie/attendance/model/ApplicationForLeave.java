package com.wqie.attendance.model;

public class ApplicationForLeave {
    private Integer id;
    private String applicantempno;
    private String reason;
    private String approverempno;
    private String leavetime;
    private String leavedate;
    private Short leavedates;
    private String approvaltime;
    private Short state;
    private String type;

    public ApplicationForLeave() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplicantempno() {
        return this.applicantempno;
    }

    public void setApplicantempno(String applicantempno) {
        this.applicantempno = applicantempno;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getApproverempno() {
        return this.approverempno;
    }

    public void setApproverempno(String approverempno) {
        this.approverempno = approverempno;
    }

    public String getLeavetime() {
        return this.leavetime;
    }

    public void setLeavetime(String leavetime) {
        this.leavetime = leavetime;
    }

    public String getLeavedate() {
        return this.leavedate;
    }

    public void setLeavedate(String leavedate) {
        this.leavedate = leavedate;
    }

    public Short getLeavedates() {
        return this.leavedates;
    }

    public void setLeavedates(Short leavedates) {
        this.leavedates = leavedates;
    }

    public String getApprovaltime() {
        return this.approvaltime;
    }

    public void setApprovaltime(String approvaltime) {
        this.approvaltime = approvaltime;
    }

    public Short getState() {
        return this.state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "ApplicationForLeave{id=" + this.id + ", applicantempno='" + this.applicantempno + "', reason='" + this.reason + "', approverempno='" + this.approverempno + "', leavetime='" + this.leavetime + "', leavedate='" + this.leavedate + "', leavedates=" + this.leavedates + ", approvaltime='" + this.approvaltime + "', state=" + this.state + ", type='" + this.type + "'}";
    }
}
