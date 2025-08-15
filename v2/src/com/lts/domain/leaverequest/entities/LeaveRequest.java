package com.lts.domain.leaverequest.entities;

import com.lts.domain.employees.entities.Employee;
import com.lts.util.enums.LeaveStatus;

public abstract class LeaveRequest{
    private int _requestId;
    private Employee _employee;
    private String _startDate;
    private String _endDate;
    private LeaveStatus _status;
    private String _reason;

    public LeaveRequest(int requestId, Employee employee, String startDate,
                        String endDate, String reason) {
        this._requestId = requestId;
        this._employee = employee;
        this._startDate = startDate;
        this._endDate = endDate;
        this._status = LeaveStatus.PENDING;
        this._reason = reason;
    }
    
    public void setRequestId(int requestId) {
        this._requestId = requestId;
    }
    public void setEmployee(Employee employee) {
        this._employee = employee;
    }
    public void setStartDate(String startDate) {
        this._startDate = startDate;
    }
    public void setEndDate(String endDate) {
        this._endDate = endDate;
    }
    public void setStatus(LeaveStatus status) {
        this._status = status;
    }
    public void setReason(String reason) {
        this._reason = reason;
    }

    public int getRequestId() {
        return this._requestId;
    }
    public Employee getEmployee() {
        return this._employee;
    }
    public String getStartDate() {
        return this._startDate;
    }
    public String getEndDate() {
        return this._endDate;
    }
    public LeaveStatus getStatus() {
        return this._status;
    }
    public String getReason() {
        return this._reason;
    }

    public boolean proceessRequest() {
        System.out.println("Processing leave request...");
        return true;
    }
}
