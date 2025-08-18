package com.lms.domain.entities;

import com.lms.domain.enums.LeaveType;

public class LeaveBalance {
    private LeaveType _leaveType;
    private int _leaveBalance;
    private Employee _employee;

    public LeaveBalance(LeaveType leaveType, int leaveBalance, Employee employee){
        this._leaveType = leaveType;
        this._leaveBalance = leaveBalance;
        this._employee = employee;
    }

    public LeaveBalance() {}

    public void setLeaveType(LeaveType leaveType) {
        this._leaveType = leaveType;
    }
    public void setLeaveBalance(int leaveBalance) {
        this._leaveBalance = leaveBalance;
    }
    public void setEmployee(Employee employee) {
        this._employee = employee;
    }

    public LeaveType getLeaveType() {
        return this._leaveType;
    }
    public int getLeaveBalance() {
        return this._leaveBalance;
    }
    public Employee getEmployee() {
        return this._employee;
    }

    public boolean deduct(int days) {
        if (_leaveBalance >= days) {
            _leaveBalance -= days;
            return true;
        }
        throw new IllegalArgumentException("Insufficient leave balance");
    }
}
