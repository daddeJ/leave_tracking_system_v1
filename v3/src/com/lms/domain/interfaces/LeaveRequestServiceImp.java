package com.lms.domain.interfaces;

import com.lms.domain.entities.Employee;
import com.lms.domain.entities.LeaveRequest;
import com.lms.domain.enums.LeaveType;

public interface LeaveRequestServiceImp {
    LeaveRequest createLeaveRequest(Employee employee, int dayRequested, LeaveType leaveType);
}
