package com.lts.domain.leaverequest.interfaces;

import com.lts.domain.employees.entities.Employee;
import com.lts.domain.leaverequest.entities.LeaveRequest;
import com.lts.util.enums.LeaveStatus;
import java.util.HashMap;

public interface ILeaveRequestService {
    boolean addLeaveRequest(LeaveRequest leaveRequest);
    HashMap<Integer, LeaveRequest> getAllLeaveRequest();
    LeaveRequest getLeaveRequestByRequestId(int requestId);
    boolean updateLeaveRequest(LeaveRequest request);
    boolean deleteLeaveRequest(int requestId);
    boolean updateLeaveRequestStatus(LeaveStatus newStatus, String changeBy, int requestId);
    boolean applyLeaveRequest(LeaveRequest leaveRequest);
    LeaveRequest getLeaveRequestsQueue(Employee employee);
}
