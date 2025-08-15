package com.lts.domain.leaverequest.services;

import com.lts.domain.employees.entities.Employee;
import com.lts.domain.leaverequest.entities.LeaveRequest;
import com.lts.domain.leaverequest.interfaces.ILeaveRequestService;
import com.lts.util.enums.EmployeeType;
import com.lts.util.enums.LeaveStatus;
import com.lts.util.helpers.DateFomatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LeaveRequestService implements ILeaveRequestService{
    private HashMap<Integer, LeaveRequest> _leaveRequestsList = new HashMap<>();
    private ArrayList<StatusChange> _statusHistory = new ArrayList<>();
    private Queue<LeaveRequest> _leaveQueue = new LinkedList<>();

    public class StatusChange {
        private LeaveStatus _oldStatus;
        private LeaveStatus _newStatus;
        private String _changeDate;
        private String _changeBy;

        public StatusChange(LeaveStatus oldStatus, LeaveStatus newStatus, 
                          String changeDate, String changedBy) {
            this._oldStatus = oldStatus;
            this._newStatus = newStatus;
            this._changeDate = changeDate;
            this._changeBy = changedBy;
        }

        public void setOldStatus(LeaveStatus status) {
            this._oldStatus = status;
        }
        public void setNewStatus(LeaveStatus status) {
            this._newStatus = status;
        }
        public void setChangeDate(String changeDate) {
            this._changeDate = changeDate;
        }
        public void setChangeBy(String changeBy) {
            this._changeBy = changeBy;
        }

        public LeaveStatus getOldStatus() {
            return this._oldStatus;
        }
        public LeaveStatus getNewStatus() {
            return this._newStatus;
        }
        public String getChangeDate() {
            return this._changeDate;
        }
        public String getChangeBy() {
            return this._changeBy;
        }
    }

    @Override
    public boolean addLeaveRequest(LeaveRequest leaveRequest) {
        if (leaveRequest == null) {
            System.out.println("Cannot add null leave request.");
            return false;
        }

        if (!_leaveRequestsList.containsKey(leaveRequest.getRequestId())) {
            _leaveRequestsList.put(leaveRequest.getRequestId(), leaveRequest);
            System.out.println("Leave request added: Request ID = " + leaveRequest.getRequestId() + 
                            ", Employee = " + leaveRequest.getEmployee().getName());
            return true;
        }

        System.out.println("Leave request with ID " + leaveRequest.getRequestId() + " already exists.");
        return false;
    }

    @Override
    public LeaveRequest getLeaveRequestByRequestId(int requestId) {
        LeaveRequest leaveRequest = _leaveRequestsList.get(requestId);
        if (leaveRequest != null) {
            System.out.println("Retrieved leave request: Request ID = " + requestId + 
                            ", Employee = " + leaveRequest.getEmployee().getName() + 
                            ", Status = " + leaveRequest.getStatus());
            return leaveRequest;
        }

        System.out.println("Leave request not found: Request ID = " + requestId);
        return null;
    }

    @Override
    public boolean updateLeaveRequest(LeaveRequest request) {
        if (request == null) {
            System.out.println("Cannot update null leave request.");
            return false;
        }

        if (_leaveRequestsList.containsKey(request.getRequestId())) {
            _leaveRequestsList.put(request.getRequestId(), request);
            System.out.println("Leave request updated: Request ID = " + request.getRequestId() + 
                            ", Employee = " + request.getEmployee().getName());
            return true;
        }

        System.out.println("No leave request found with ID " + request.getRequestId());
        return false;
    }

    @Override
    public boolean deleteLeaveRequest(int requestId) {
        if (_leaveRequestsList.containsKey(requestId)) {
            LeaveRequest removed = _leaveRequestsList.remove(requestId);
            System.out.println("Leave request deleted: Request ID = " + requestId + 
                            ", Employee = " + removed.getEmployee().getName());
            return true;
        }

        System.out.println("No leave request found to delete: Request ID = " + requestId);
        return false;
    }

    @Override
    public HashMap<Integer, LeaveRequest> getAllLeaveRequest() {
        System.out.println("Retrieving all leave requests. Total: " + _leaveRequestsList.size());
        return this._leaveRequestsList;
    }

    @Override
    public boolean updateLeaveRequestStatus(LeaveStatus newStatus, String changeBy, int requestId) {
        LeaveRequest tmpLeaveRequest = getLeaveRequestByRequestId(requestId);

        if (tmpLeaveRequest == null) {
            System.out.println("Cannot update status: Leave request not found for Request ID = " + requestId);
            return false;
        }

        LeaveStatus oldStatus = tmpLeaveRequest.getStatus();
        StatusChange change = new StatusChange(oldStatus, newStatus, DateFomatter.getCurrentDate(), changeBy);
        tmpLeaveRequest.setStatus(newStatus);
        this._statusHistory.add(change);

        System.out.println("Updated leave request status: Request ID = " + requestId + 
                        ", Old Status = " + oldStatus + 
                        ", New Status = " + newStatus + 
                        ", Changed By = " + changeBy + 
                        ", Change Date = " + change.getChangeDate());
        return true;
    }

    @Override
    public LeaveRequest getLeaveRequestsQueue(Employee employee) {
        if (employee.getEmployeeType() == EmployeeType.HR) {
            LeaveRequest nextRequest = this._leaveQueue.poll();
            if (nextRequest != null) {
                System.out.println("Next leave request retrieved from queue: Request ID = " + nextRequest.getRequestId() +
                                ", Employee = " + nextRequest.getEmployee().getName());
            } else {
                System.out.println("No pending leave requests in the queue.");
            }
            return nextRequest;
        }

        System.out.println("Employee is not HR. Cannot retrieve leave requests from queue.");
        return null;
    }

    @Override
    public boolean applyLeaveRequest(LeaveRequest leaveRequest) {
        if (leaveRequest == null) {
            System.out.println("Cannot apply null leave request.");
            return false;
        }

        this._leaveQueue.add(leaveRequest);
        System.out.println("Leave request applied and added to queue: Request ID = " + leaveRequest.getRequestId() +
                        ", Employee = " + leaveRequest.getEmployee().getName());
        return true;
    }
}
