package com.lms.domain.interfaces;

import com.lms.domain.entities.Employee;
import com.lms.domain.entities.LeaveRequest;

public interface ApprovalServiceImp {
    LeaveRequest reviewRequest(Employee employee);
    LeaveRequest approveRequest(LeaveRequest leaveRequest);
    LeaveRequest denyRequest(LeaveRequest leaveRequest);
}
