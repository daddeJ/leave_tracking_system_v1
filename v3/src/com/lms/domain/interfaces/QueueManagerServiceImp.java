package com.lms.domain.interfaces;

import com.lms.domain.entities.LeaveRequest;

public interface QueueManagerServiceImp {
    LeaveRequest getPendingRequest();
    boolean addRequest(LeaveRequest leaveRequest);
    boolean removeRequest(LeaveRequest leaveRequest);
}
