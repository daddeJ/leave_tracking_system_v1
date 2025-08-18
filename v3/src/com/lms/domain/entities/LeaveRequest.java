package com.lms.domain.entities;

import com.lms.domain.enums.LeaveStatus;
import com.lms.domain.enums.LeaveType;

public class LeaveRequest {
    private int _requestId;
    private Employee _employee;
    private int _dayRequested;
    private LeaveStatus _leaveStatus;
    private LeaveType _leaveType;

    public LeaveRequest(int requestId, Employee employee, LeaveType leaveType, int dayRequested) {
        this._requestId = requestId;
        this._employee = employee;
        this._dayRequested = dayRequested;
        this._leaveStatus = LeaveStatus.PENDING;
        this._leaveType = leaveType; 
    }
    
    public void setRequestId(int requestId) {
        this._requestId = requestId;
    }
    public void setEmployee(Employee employee) {
        this._employee = employee;
    }
    public void setDayRequested(int dayRequested) {
        this._dayRequested = dayRequested;
    }
    public void setLeaveStatus(LeaveStatus leaveStatus) {
        this._leaveStatus = leaveStatus;
    }
    public void setLeaveType(LeaveType leaveType) {
        this._leaveType = leaveType;
    }

    public int getRequestId() {
        return this._requestId;
    }
    public Employee getEmployee() {
        return this._employee;
    }
    public int getDayRequested() {
        return this._dayRequested;
    }
    public LeaveStatus getLeaveStatus() {
        return this._leaveStatus;
    }
    public LeaveType getLeaveType() {
        return this._leaveType;
    }

    public void approve() {
        this._leaveStatus = LeaveStatus.APPROVED;
    }

    public void deny() {
        this._leaveStatus = LeaveStatus.DENIED;
    }

    public String toString() {
        return "=== Leave Request ===" +
                "\n\nRequest By:" + this._employee.getName() +
                "\nLeave: " + this._leaveType.toString() + 
                "\nStatus: " + this._leaveStatus.toString() +
                "\n\n====================";
    }
}
