package com.lts.domain.leaverequest.services;

import com.lts.domain.leaverequest.entities.LeaveRequest;
import com.lts.domain.leaverequest.interfaces.ILeaveTrackingService;
import com.lts.util.enums.LeaveStatus;
import java.util.HashMap;

public class LeaveTrackingService implements ILeaveTrackingService{
    
    private HashMap<Integer, LeaveRequest> _leaveRequestHistory = new HashMap<>();
    @Override
    public boolean archiveLeaveRequest(LeaveRequest leaveRequest) {
        if (leaveRequest == null) {
            System.out.println("Cannot archive null leave request.");
            return false;
        }

        if (leaveRequest.getStatus() == LeaveStatus.PENDING) {
            System.out.println("Cannot archive leave request. Request is still PENDING: Request ID = " 
                            + leaveRequest.getRequestId());
            return false;
        }

        this._leaveRequestHistory.put(leaveRequest.getRequestId(), leaveRequest);
        System.out.println("Leave request archived: Request ID = " + leaveRequest.getRequestId() + 
                        ", Employee = " + leaveRequest.getEmployee().getName() + 
                        ", Status = " + leaveRequest.getStatus());
        return true;
    }

    @Override
    public HashMap<Integer, LeaveRequest> getLeaveRequestHistory() {
        System.out.println("Retrieving leave request history. Total archived: " + _leaveRequestHistory.size());
        return this._leaveRequestHistory;
    }

}
