package com.lms.domain.services;

import java.util.LinkedList;

import com.lms.domain.entities.LeaveRequest;
import com.lms.domain.interfaces.QueueManagerServiceImp;

public class QueueManagerService implements QueueManagerServiceImp{
    private LinkedList<LeaveRequest> leaveRequestQueue = new LinkedList<>();
    @Override
    public LeaveRequest getPendingRequest() {
        return leaveRequestQueue.peekFirst();
    }

    @Override
    public boolean addRequest(LeaveRequest leaveRequest) {
        if (leaveRequest == null)
            throw new IllegalStateException("Leave Request not found for employee");
        leaveRequestQueue.add(leaveRequest);
        return true;
    }

    @Override
    public boolean removeRequest(LeaveRequest leaveRequest) {
        if (leaveRequest == null)
            throw new IllegalStateException("Leave Request not found for employee");
        
        leaveRequestQueue.removeFirstOccurrence(leaveRequest);
        return true;
    }

}
