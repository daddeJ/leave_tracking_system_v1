package domain.leave;

import java.util.HashMap;
import domain.port.ILeaveRequestService;

public class LeaveRequestService implements ILeaveRequestService{
    private HashMap<Integer, LeaveRequest> _leaveRequestsList = new HashMap<>();

    @Override
    public boolean addLeaveRequest(LeaveRequest leaveRequest) {
        if (!_leaveRequestsList.containsKey(leaveRequest.getRequestId())) {
            _leaveRequestsList.put(leaveRequest.getRequestId(), leaveRequest);
            System.out.println(
                "Leave request added."
            );
            return true;
        }
        
        System.out.println(
            "Leave request with this ID already exists."
        );
        return false;
    }

    @Override
    public LeaveRequest getLeaveRequestByRequestId(int requestId) {
        if (_leaveRequestsList.containsKey(requestId)) {
            return _leaveRequestsList.get(requestId);
        }

        System.out.println(
            "Leave request not found."
        );
        return null;
    }

    @Override
    public boolean updateLeaveRequest(LeaveRequest request) {
        if (_leaveRequestsList.containsKey(request.getRequestId())) {
            _leaveRequestsList.put(request.getRequestId(), request);
            System.out.println(
                "Leave request of " + request.getEmployee().getName() + " updated"
            );
            return true;
        }

        System.out.println(
            "No leave request found."
        );
        return false;
    }

    @Override
    public boolean deleteLeaveRequest(int requestId) {
        if (_leaveRequestsList.containsKey(requestId)) {
            _leaveRequestsList.remove(requestId);
            System.out.println(
                "Leave request deleted"
            );
            return true;
        }

        System.out.println(
            "No leave request found."
        );
        return false;
    }

    @Override
    public HashMap<Integer, LeaveRequest> getAllLeaveRequest() {
        return this._leaveRequestsList;
    }
}
