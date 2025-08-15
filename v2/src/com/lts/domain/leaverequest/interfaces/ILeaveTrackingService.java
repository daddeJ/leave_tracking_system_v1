package com.lts.domain.leaverequest.interfaces;

import com.lts.domain.leaverequest.entities.LeaveRequest;
import java.util.HashMap;

public interface ILeaveTrackingService {
    boolean archiveLeaveRequest(LeaveRequest leaveRequest);
    HashMap<Integer, LeaveRequest> getLeaveRequestHistory();
    
}
