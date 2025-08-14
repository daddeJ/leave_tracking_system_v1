package domain.port;

import java.util.ArrayList;
import java.util.HashMap;

import domain.leave.LeaveRequest;

public interface ILeaveRequestService {
    boolean addLeaveRequest(LeaveRequest leaveRequest);
    HashMap<Integer, LeaveRequest> getAllLeaveRequest();
    LeaveRequest getLeaveRequestByRequestId(int requestId);
    boolean updateLeaveRequest(LeaveRequest request);
    boolean deleteLeaveRequest(int requestId);
}
