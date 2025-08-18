package com.lms.domain.services;

import java.util.HashMap;

import com.lms.domain.entities.Employee;
import com.lms.domain.entities.LeaveRequest;
import com.lms.domain.enums.LeaveType;
import com.lms.domain.interfaces.LeaveRequestServiceImp;

public class LeaveRequestService implements LeaveRequestServiceImp{
    private HashMap<Integer, LeaveRequest> leaveRequestList = new HashMap<>();

    @Override
    public LeaveRequest createLeaveRequest(Employee employee, int dayRequested, LeaveType leaveType) {
        int requestId = generateRequestId();
        LeaveRequest tmpLeaveRequest = new LeaveRequest(requestId, employee, leaveType, dayRequested);
        leaveRequestList.put(requestId, tmpLeaveRequest);
        return tmpLeaveRequest;
    }

    private int generateRequestId() {
        return leaveRequestList.size() + 1;
    }
}
