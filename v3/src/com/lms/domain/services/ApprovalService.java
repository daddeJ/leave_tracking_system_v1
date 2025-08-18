package com.lms.domain.services;

import com.lms.domain.entities.Employee;
import com.lms.domain.entities.LeaveRequest;
import com.lms.domain.enums.Department;
import com.lms.domain.interfaces.ApprovalServiceImp;
import com.lms.domain.interfaces.LeaveBalanceServiceImp;
import com.lms.domain.interfaces.QueueManagerServiceImp;

public class ApprovalService implements ApprovalServiceImp{
    private final QueueManagerServiceImp _queueManagerServiceImp;
    private final LeaveBalanceServiceImp _leaveBalanceServiceImp;

    public ApprovalService(QueueManagerServiceImp queueManagerServiceImp, LeaveBalanceServiceImp leaveBalanceServiceImp) {
        this._queueManagerServiceImp = queueManagerServiceImp;
        this._leaveBalanceServiceImp = leaveBalanceServiceImp;
    }

    @Override
    public LeaveRequest reviewRequest(Employee employee) {
        if (employee.getDepartment() != Department.HR) {
            throw new IllegalStateException("Employee cannot view Request");
        }
        return _queueManagerServiceImp.getPendingRequest();
    }

    @Override
    public LeaveRequest approveRequest(LeaveRequest leaveRequest) {
        leaveRequest.approve();
        _leaveBalanceServiceImp.deductLeaveBalance(leaveRequest);
        return leaveRequest;
    }

    @Override
    public LeaveRequest denyRequest(LeaveRequest leaveRequest) {
        leaveRequest.deny();
        return leaveRequest;
    }

}
