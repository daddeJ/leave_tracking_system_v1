package com.lms.domain.interfaces;

import java.util.List;

import com.lms.domain.entities.Employee;
import com.lms.domain.entities.LeaveBalance;
import com.lms.domain.entities.LeaveRequest;
import com.lms.domain.enums.LeaveType;

public interface LeaveBalanceServiceImp {
    void addLeaveBalance(Employee employee, LeaveType leaveType);
    List<LeaveBalance> getLeaveBalanceByEmployee(Employee employee);
    LeaveBalance deductLeaveBalance(LeaveRequest leaveRequest);
}
